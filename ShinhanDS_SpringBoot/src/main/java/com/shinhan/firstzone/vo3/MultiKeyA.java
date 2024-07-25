package com.shinhan.firstzone.vo3;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MultiKeyA implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id1;
	private Integer id2;
}
