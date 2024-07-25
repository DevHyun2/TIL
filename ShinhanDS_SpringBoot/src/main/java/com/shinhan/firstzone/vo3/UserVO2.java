package com.shinhan.firstzone.vo3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "t_user2")
public class UserVO2 {

	@Id
	@Column(name = "user_id")
	String userid;
	@Column(name = "user_name")
	String username;

}
