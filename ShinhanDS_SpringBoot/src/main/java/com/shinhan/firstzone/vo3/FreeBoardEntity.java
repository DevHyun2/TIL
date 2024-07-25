//package com.shinhan.firstzone.vo3;
//
//import java.sql.Timestamp;
//import java.util.List;
//
//import org.hibernate.annotations.BatchSize;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
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
////@AllArgsConstructor
//@NoArgsConstructor
//@Getter@Setter
////@ToString(exclude = {"replies"})
////@EqualsAndHashCode(of = "bno")
////@Entity
////@Table(name = "t_freeboard")
//public class FreeBoardEntity {
//	
//	@Id//pk
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	Long bno;
//	String title;
//	String writer;
//	String content;
//	@CreationTimestamp //insert시 자동
//	Timestamp regdate;
//	@UpdateTimestamp //insert, update시 자동
//	Timestamp updatedate;
//	//N+1 해결방법중 하나. Join사용시 대상entity에 개수만큼 상대entity를 select
//	//in을 사용하여 BatchSize만큼 한꺼번에 select가능
//	@BatchSize(size = 100)
//	//하나의 board에 댓글이 여러개(부모)
//	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	List<FreeReplyEntity> replies;
//}
