package com.shinhan.firstzone;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shinhan.firstzone.repository.GuestBookRepository;
import com.shinhan.firstzone.vo2.GuestBookDTO;
import com.shinhan.firstzone.vo2.GuestBookEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //필수field를 constructor를 통해 injection = autowired
public abstract class GuestBookServiceImpl implements GuestBookService{
	
	final GuestBookRepository gRepo;

	@Override
	public void create(GuestBookDTO dto) {
		GuestBookEntity entity = dtoToEntity(dto);
		gRepo.save(entity);
		
	}

	@Override
	public List<GuestBookDTO> readAll() {
		List<GuestBookEntity> entityList = (List<GuestBookEntity>) gRepo.findAll();
		List<GuestBookDTO> dtoList = entityList.stream().map(entity->entityToDTO(entity)).toList();
		return dtoList;
	}
	
	@Override
	public GuestBookDTO readById(Long gno) {
		GuestBookEntity entity = gRepo.findById(gno).orElse(null);
		return entityToDTO(entity);
	}
	
	@Override
	public void update(GuestBookDTO dto) {
		gRepo.save(dtoToEntity(dto));		
	}

	@Override
	public void delete(Long gno) {
		gRepo.deleteById(gno);		
	}
	
	
}
