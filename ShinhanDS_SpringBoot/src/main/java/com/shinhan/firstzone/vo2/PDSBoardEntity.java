package com.shinhan.firstzone.vo2;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//하나의 Board에 첨부 file이 여러 개 있다.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_pdsboard")
public class PDSBoardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long pid;
	String pname;
	String writer;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pdsno") //PDSFileEntity의 테이블에 pdsno 칼럼이 생성
	//JoinColumn이 생략되면 PDSBoard키, PDSFileEntity키를 칼럼으로 갖는 중간 테이블이 생성
	List<PDSFileEntity> files;
}