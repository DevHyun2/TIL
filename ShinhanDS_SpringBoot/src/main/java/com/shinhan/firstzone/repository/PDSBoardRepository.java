package com.shinhan.firstzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shinhan.firstzone.vo2.PDSBoardEntity;

public interface PDSBoardRepository extends JpaRepository<PDSBoardEntity, Long> {

	// 1.기본 CRUD
	// 2.규칙에 맞는 함수
	List<PDSBoardEntity> findByWriter(String writer);

	@Query("select b.pname, b.writer, f.pdsfilename " 
			+ "from #{#entityName} b left outer join b.files f " // 연관관계가 있으면
			+ "where b.pid = ?1 order by b.pid")
	public List<Object[]> getFilesInfo2(long pid);

	@Query("select b.pname, count(f) " 
			+ " from #{#entityName} b left outer join b.files f where b.pid>0 "
			+ " group by b.pname order by b.pname ")
	public List<Object[]> getFilesCount2();

	@Query(value = "select f.pdsno, count(f.pdsno) from t_pdsboard b "
			+ " left outer join t_pdsfile f on(b.pid=f.pdsno) group by f.pdsno order by 1 ", 
			nativeQuery = true)
	public List<Object[]> getFilesCount3();

	//@Query는 기본적으로 Select만 지원, DML(insert, delete, update)를 하려면 @Modifying을 추가
	@Modifying 
	@Query("UPDATE PDSFileEntity f set f. pdsfilename = ?2 WHERE f.fno = ?1 ") 
	int updatePDSFile(Long fno, String newFileName); 

}
