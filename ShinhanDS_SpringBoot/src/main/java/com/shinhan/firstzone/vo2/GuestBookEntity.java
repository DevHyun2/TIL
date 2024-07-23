package com.shinhan.firstzone.vo2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "t_guestbook")
@Entity //JPA가 관리하는 객체(DB의 객체와 JABA의 객체를 Mapping)
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Data //get, set, toString, equalsandhashcode/Noargmentconstructor
@Getter@Setter
public class GuestBookEntity extends BaseEntity {
	
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long gno;
	@Column(length = 100, nullable = false)
	String title;
	@Column(length = 2000)
	String content;
	@Column(length = 50)
	String writer;
	@Override
	public String toString() {
		return "GuestBookEntity [gno=" + gno + ", title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}
}
