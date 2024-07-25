package com.shinhan.firstzone.vo3;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable //복합키로 사용하겠다의 의미
public class MultiKeyB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id1;
	private Integer id2;
}
