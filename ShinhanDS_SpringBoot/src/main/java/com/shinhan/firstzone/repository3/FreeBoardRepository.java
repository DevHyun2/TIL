//package com.shinhan.firstzone.repository3;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.shinhan.firstzone.vo3.FreeBoardEntity;
//
////join : N+1 문제
////joinfetch : N+1 문제해결
//public interface FreeBoardRepository extends JpaRepository<FreeBoardEntity, Long>{
//	
//	//@Query("select from #{#entityName} b join b.replies")
//	List<FreeBoardEntity> findAllWithReplyByUsingJoin();
//	
//	//@Query("select from #{#entityName} b join b.replies")
//	List<FreeBoardEntity> findAllWithReplyByUsingJoinFetch();
//}
