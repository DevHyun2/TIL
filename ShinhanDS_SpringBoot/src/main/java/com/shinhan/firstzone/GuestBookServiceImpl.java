package com.shinhan.firstzone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.shinhan.firstzone.repository.GuestBookRepository;
import com.shinhan.firstzone.vo2.GuestBookDTO;
import com.shinhan.firstzone.vo2.GuestBookEntity;
import com.shinhan.firstzone.vo2.QGuestBookEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor  // 필수 field를 constructor를 통해 injection
public class GuestBookServiceImpl implements GuestBookService{

	final GuestBookRepository gRepo;
	
	@Override
	public void create(GuestBookDTO dto) {
		GuestBookEntity entity = dtoToEntity(dto);
		gRepo.save(entity);
	}

	@Override
	public List<GuestBookDTO> readAll() {
		List<GuestBookEntity> entityList = (List<GuestBookEntity>)gRepo.findAll();
		List<GuestBookDTO> dtoList = 
				entityList.stream().map(entity -> entityToDTO(entity))
									.collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public GuestBookDTO readById(Long gno) {
		GuestBookEntity entity = gRepo.findById(gno).orElse(null);
		return entityToDTO(entity);
	}

	@Override
	public void update(GuestBookDTO dto) {
		gRepo.findById(dto.getGno()).ifPresent(book->{
			book.setContent(dto.getContent());
			book.setTitle(dto.getTitle());
			book.setWriter(dto.getWriter());
			gRepo.save(book);
		});
	}

	@Override
	public void delete(Long gno) {
		gRepo.deleteById(gno);
	}
	
	public List<GuestBookDTO> getSearch(String type, String keyword) {
		BooleanBuilder builder = new BooleanBuilder();
		QGuestBookEntity entity = QGuestBookEntity.guestBookEntity;
		
		BooleanExpression expression = entity.gno.gt(0L); //gno > 0
		builder.and(expression); // select g from GuestBookEntity g where g.gno > 0
		
		BooleanBuilder builder2 = new BooleanBuilder();
		if(type.contains("t")) {
			builder2.or(entity.title.contains(keyword));
		}
		
		if(type.contains("c")) {
			builder2.or(entity.content.contains(keyword));
		}
		
		if(type.contains("w")) {
			builder2.or(entity.writer.contains(keyword));
		}
		
		builder.and(builder2);
		
		List<GuestBookEntity> entityList = (List<GuestBookEntity>)gRepo.findAll(builder);
		List<GuestBookDTO> dtoList = 
				entityList.stream().map(e -> entityToDTO(e))
									.collect(Collectors.toList());
		return dtoList;
	}
}