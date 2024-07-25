package com.shinhan.firstzone.service2;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.firstzone.repository4.WebBoardRepository;
import com.shinhan.firstzone.vo2.MemberEntity;
import com.shinhan.firstzone.vo4.WebBoardDTO;
import com.shinhan.firstzone.vo4.WebBoardEntity;

@Service
public class WebBoardServiceImpl implements WebBoardService{

	@Autowired
	WebBoardRepository boardRepo;
	
	@Override
	public Long register(WebBoardDTO dto) {
		WebBoardEntity newEntity = boardRepo.save(dtoToEntity(dto));
		return newEntity.getBno();
	}

	@Override
	public List<WebBoardDTO> getList() {
		List<WebBoardDTO> blist = boardRepo.findAll().stream().map(en->entityToDTO(en))
				.collect(Collectors.toList());
		return blist;
	}

	@Override
	public WebBoardDTO selectById(Long bno) {
		WebBoardEntity en = boardRepo.findById(bno).orElse(null);
		if(en==null) return null;
		return entityToDTO(en);
	}

	@Override
	public void modify(WebBoardDTO dto) {
		boardRepo.findById(dto.getBno()).ifPresent(en->{
			en.setContent(dto.getContent());
			en.setTitle(dto.getTitle());
			MemberEntity member = MemberEntity.builder().mid(dto.getMid()).build();
			en.setWriter(member);
			boardRepo.save(en);
		});
	}

	@Override
	public void delete(Long bno) {
		boardRepo.deleteById(bno);
	}
}
