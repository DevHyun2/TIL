package com.shinhan.firstzone;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.firstzone.repository.EnumTypeVORepository;
import com.shinhan.firstzone.vo2.MemberRole;
import com.shinhan.firstzone.vo3.EnumTypeVO;

@SpringBootTest
class EnumTypeTest {

	@Autowired
	EnumTypeVORepository repo;
	
	@Test
	void f1() {
		Set<MemberRole> mrole = new HashSet<>();
		mrole.add(MemberRole.ADMIN);
		mrole.add(MemberRole.USER);
		
		EnumTypeVO vo = EnumTypeVO.builder()
				.mid("happy")
				.mname("현")
				.mpassword("1234")
				.mrole(mrole)
				.build();
		
		repo.save(vo);
	}

}
