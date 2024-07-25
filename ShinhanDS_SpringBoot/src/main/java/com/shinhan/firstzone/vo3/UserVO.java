package com.shinhan.firstzone.vo3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "t_user")
public class UserVO {

	@Id
	@Column(name = "user_id")
	String userid;
	@Column(name = "user_name")
	String username;

	//주 테이블에서 참조하기 
	@OneToOne
	@JoinColumn(name = "phone_id")
	UserCellPhoneVO phone;

}
