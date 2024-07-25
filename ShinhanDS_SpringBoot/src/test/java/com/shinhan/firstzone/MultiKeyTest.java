package com.shinhan.firstzone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.firstzone.repository.MultiKeyARepository;
import com.shinhan.firstzone.repository.MultiKeyBRepository;
import com.shinhan.firstzone.vo3.MultiKeyA;
import com.shinhan.firstzone.vo3.MultiKeyAClass;
import com.shinhan.firstzone.vo3.MultiKeyB;
import com.shinhan.firstzone.vo3.MultiKeyBClass;

@SpringBootTest
public class MultiKeyTest {

	@Autowired
	MultiKeyARepository aRepo;
	@Autowired
	MultiKeyBRepository bRepo;
	
	//@Test
	void selectB() {
		MultiKeyB bKey = MultiKeyB.builder().id1(1).id2(2).build();
		bRepo.findById(bKey).ifPresent(b->System.out.println(b));
	}
		
	//@Test
	void insertB() {
		MultiKeyB bKey = MultiKeyB.builder()
				.id1(2).id2(3)
				.build();
		MultiKeyBClass b = MultiKeyBClass.builder()
				.multib(bKey)
				.productName("커피")
				.price(100)
				.build();
		bRepo.save(b);
	}
	
	//@Test
	void selectA2() {
		aRepo.findById1(10).forEach(aa->System.out.println(aa));
	}
	
	//@Test
	void selectA() {
		MultiKeyA aKey = MultiKeyA.builder().id1(10).id2(20).build();
		aRepo.findById(aKey).ifPresent(a->System.out.println(a));
	}
	
	//@Test
	void insertA() {
		MultiKeyAClass a = MultiKeyAClass.builder()
				.id1(20)
				.id2(30)
				.productName("커피")
				.price(100)
				.build();
		aRepo.save(a);
	}
}
