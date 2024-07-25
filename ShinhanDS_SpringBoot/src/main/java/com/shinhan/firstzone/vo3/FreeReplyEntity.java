//package com.shinhan.firstzone.vo3;
//
//import java.sql.Timestamp;
//import java.util.List;
//
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
////@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter@Setter
//@ToString
////@EqualsAndHashCode(of = "rno")
////@Entity
////@Table(name = "t_freereply")
//public class FreeReplyEntity {
//	
//	@Id//pk
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	Long rno;
//	String reply;
//	String replyer;
//	@CreationTimestamp //insert시 자동
//	Timestamp regdate;
//	@UpdateTimestamp //insert, update시 자동
//	Timestamp updatedate;
//	
//	//하나의 board에 댓글리 여러개(자식)
//	@ManyToOne(fetch = FetchType.EAGER) //DB의 칼럼은 board_bno
//	private FreeBoardEntity board;
//}
