package com.shinhan.firstzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shinhan.firstzone.vo2.PDSFileEntity;

public interface PDSFileRepository extends JpaRepository<PDSFileEntity, Long>{

	//1.기본 CRUD 함수 ex) findAll()
	//2.규칙에 맞는 함수 제작
	PDSFileEntity findByPdsfilename(String pname);
}
