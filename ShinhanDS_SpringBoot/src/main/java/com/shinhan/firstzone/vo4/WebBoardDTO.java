package com.shinhan.firstzone.vo4;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO: Data Transfer Object
//VO: Value Object
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebBoardDTO {
	private Long bno;
	private String title;
	private String mid;
	private String mname;
	private String content;
	private Timestamp regdate;
	private Timestamp updatedate;
	private int replyCount;
}
