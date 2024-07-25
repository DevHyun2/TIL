package com.shinhan.firstzone.vo2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_profile")
public class ProfileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long fno;
	String fname;
	boolean currentYn;
	@ManyToOne // 하나의 멤버가 여러 개의 프로필을 가진다
	MemberEntity member;
}
