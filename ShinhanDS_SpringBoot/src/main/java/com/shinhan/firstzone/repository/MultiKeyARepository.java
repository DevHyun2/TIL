package com.shinhan.firstzone.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shinhan.firstzone.vo3.MultiKeyA;
import com.shinhan.firstzone.vo3.MultiKeyAClass;

public interface MultiKeyARepository extends CrudRepository<MultiKeyAClass, MultiKeyA> {
	
	List<MultiKeyAClass> findById1(int num);
	List<MultiKeyAClass> findById2(int num);
}
