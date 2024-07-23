package com.shinhan.firstzone.vo2;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "t_member")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberEntity {

	@Id //Primary Key
	String mid;
	String mpassword;
	String mname;
	@Enumerated(EnumType.STRING) //기본은 순서orinal이 입력됨 
	MemberRole mrole;  
	
}
