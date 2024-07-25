package com.shinhan.firstzone.vo4;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Table(name="t_webreply")
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@ToString(exclude = {"board"})
@EqualsAndHashCode(of = "rno")
@Entity
public class WebReplyEntity {

	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rno;
	private String reply; //댓글 내용
	private String replyer; //댓글 작성자
	
	@CreationTimestamp //insert 시, 자동
	private Timestamp regdate;
	@UpdateTimestamp //insert, update 시, 자동
	private Timestamp updatedate;
	
	//하나의 board에 댓글이 여러개 있음(자식)
	@ManyToOne(fetch = FetchType.EAGER) //DB의 칼럼 이름은 board_bno
	private WebBoardEntity board;
}
