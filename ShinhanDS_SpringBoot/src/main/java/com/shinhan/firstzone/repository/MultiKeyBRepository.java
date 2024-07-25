package com.shinhan.firstzone.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shinhan.firstzone.vo3.MultiKeyB;
import com.shinhan.firstzone.vo3.MultiKeyBClass;

public interface MultiKeyBRepository extends CrudRepository<MultiKeyBClass, MultiKeyB> {
	
	List<MultiKeyBClass> findByMultib(MultiKeyB bKey);
}
