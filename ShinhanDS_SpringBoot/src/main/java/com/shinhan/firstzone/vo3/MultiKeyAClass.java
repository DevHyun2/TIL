package com.shinhan.firstzone.vo3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "t_child1")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(MultiKeyA.class)
public class MultiKeyAClass {

	@Id
	private Integer id1;
	@Id
	private Integer id2;
	
	String productName;
	int price;
}
