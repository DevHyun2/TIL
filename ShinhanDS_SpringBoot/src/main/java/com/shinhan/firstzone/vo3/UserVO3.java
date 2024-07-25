package com.shinhan.firstzone.vo3;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tbl_user3")
public class UserVO3 {

	@Id
	@Column(name = "user_id")
	String userid;
	@Column(name = "user_name")
	String username;

	//주 테이블에서 참조하기 
	@OneToOne(mappedBy = "user3", cascade = CascadeType.ALL)
	UserCellPhoneVO3 phone;

}
