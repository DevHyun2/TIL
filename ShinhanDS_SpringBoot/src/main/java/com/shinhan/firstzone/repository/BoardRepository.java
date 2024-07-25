package com.shinhan.firstzone.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.shinhan.firstzone.vo.BoardEntity;

//Repository 설계
//JPA -> Interface 기반으로 구현 class 생성
public interface BoardRepository extends CrudRepository<BoardEntity, Long>, 
									PagingAndSortingRepository<BoardEntity, Long>{

	//1. 기본 CRUD는 제공 : findAll(), findById(), save(), count(), delete()
	//2. 규칙에 맞는 함수를 정의
	//https://docs.spring.io/spring-data/jpa/docs/2.5.1/reference/html/#jpa.query-methods
	
	List<BoardEntity> findByWriter(String writer);           //where writer = 'A'
	List<BoardEntity> findByTitleStartingWith(String title); //where title like 'A%'
	List<BoardEntity> findByTitleEndingWith(String title);   //where title like '%A'
	List<BoardEntity> findByTitleContaining(String title);   //where title like '%A%'
	List<BoardEntity> findByBnoBetween(Long start, Long end);//where bno >= ? and bno <= ?

	//where content like '%aa%' and (bno >= ? and bno <= ?) order by bno desc
	List<BoardEntity> findByContentLikeAndBnoBetweenOrderByBnoDesc(String content, Long bno1, Long bno2);
	
	//paging 추가
	List<BoardEntity> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable pagable);
	
	//3. JPQL(JPA Query Language) 이용하기 : 복잡한 SQL문 생성 시 이용
	//주의: nativeQuery와 비슷하지만 같지는 않다. ex) * 불가
	@Query("select b from BoardEntity b "
			+ "where b.title like %?1% and b.content like %?2% order by bno desc")
	List<BoardEntity> jpqlTest1(String title, String content);
	
	@Query("select b from BoardEntity b "
			+ "where b.title like %:tt% and b.content like %:cc% order by bno desc")
	List<BoardEntity> jpqlTest2(@Param("tt") String title, @Param("cc") String content);
	
	@Query("select b from #{#entityName} b "
			+ "where b.title like %:tt% and b.content like %:cc% order by bno desc")
	List<BoardEntity> jpqlTest3(@Param("tt") String title, @Param("cc") String content);
	
	@Query("select b.title, b.content, b.writer from #{#entityName} b "
			+ "where b.title like %:tt% and b.content like %:cc% order by bno desc")
	List<Object[]> jpqlTest4(@Param("tt") String title, @Param("cc") String content);
	
	@Query(value = "select * from t_board b "
			+ "where b.title like ?1 and b.content like ?2 order by b.bno desc"
			,nativeQuery = true)
	List<BoardEntity> jpqlTest5(String title, String content);
}
