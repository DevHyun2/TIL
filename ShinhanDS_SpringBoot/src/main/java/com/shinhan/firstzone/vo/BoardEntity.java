package com.shinhan.firstzone.vo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //JPA가 관리하는 대상 ... DB의 table과 Mapping할 때 사용
@Table(name = "t_board")
public class BoardEntity {
	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	@Column(length = 50, nullable = false)
	private String title;
	@Column(length = 2000)
	private String content;
	private String writer;
	@Column(name = "regDate")
	@CreationTimestamp //insert시 입력
	private Timestamp regDate;
	@UpdateTimestamp //update시 입력
	private Timestamp updateDate;
}
