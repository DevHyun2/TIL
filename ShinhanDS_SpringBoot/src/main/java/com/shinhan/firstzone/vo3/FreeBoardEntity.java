package com.shinhan.firstzone.vo3;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Table(name="t_freeboard")
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@ToString(exclude= {"replies"})
@EqualsAndHashCode(of = "bno")
@Entity
public class FreeBoardEntity {

	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	private String title;
	private String writer;
	private String content;
	@CreationTimestamp //insert 시, 자동
	private Timestamp regdate;
	@UpdateTimestamp //insert, update 시, 자동
	private Timestamp updatedate;
	
	@JsonIgnore
	//N+1 해결 방법 중 하나, join 사용 시, 대상 entity의 개수만큼 상대 entity를 select하는 문장이 생성
	//Batchsize 사용 시, in을 사용하여 size의 크기만큼 한번에 select 가능
	@BatchSize(size=100)
	//하나의 board에 댓글이 여러개 있음(부모)
	@OneToMany(mappedBy = "board"
			,cascade = CascadeType.ALL //모든 전의
			,fetch = FetchType.LAZY) //즉시 로딩
	private List<FreeReplyEntity> replies;
}
