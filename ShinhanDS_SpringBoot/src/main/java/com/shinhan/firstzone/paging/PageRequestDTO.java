package com.shinhan.firstzone.paging;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PageRequestDTO {
	private int page;
	private int size   ;
	private String type;
	private String keyword;
	public PageRequestDTO(int page, int size){
		this.page = page;
		this.size = size  ;		
	}
	public Pageable getPageable(Sort sort) { 
		return PageRequest.of(page-1, size, sort);
	}
}








