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

@Table(name = "t_profile")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long fno;
	String fname;
	boolean currentYn;
	
	//여러개의 prifile은 하나의 Member소유이다. 
	@ManyToOne //하나의 member는 여러개의 Profile를 갖는다. 
	//칼럼이름은 filed이름_키field
	//member_mid칼럼이 생성된다. 
	MemberEntity member;
}
