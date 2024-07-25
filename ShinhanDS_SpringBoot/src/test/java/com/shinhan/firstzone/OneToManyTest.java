package com.shinhan.firstzone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.shinhan.firstzone.repository.PDSBoardRepository;
import com.shinhan.firstzone.repository.PDSFileRepository;
import com.shinhan.firstzone.vo2.PDSBoardEntity;
import com.shinhan.firstzone.vo2.PDSFileEntity;

import jakarta.transaction.Transactional;

@Commit
@SpringBootTest
public class OneToManyTest {

	@Autowired
	PDSFileRepository fileRepo;
	
	@Autowired
	PDSBoardRepository boardRepo;
	
	//보드 삭제
	@Test
	void deleteBoard() {
		boardRepo.deleteById(10L);
	}
	
	//파일 삭제
	//@Test
	void deleteFile() {
		fileRepo.deleteById(54L);
	}
	
	//boardRepo에서 PDSFile을 수정하기, 직접 SQL 작성
	//@Transactional 추가하기, 실행 후 test 환경은 rollback 처리되기 때문에 commit 추가
	@Transactional
	//@Test
	void updateFile() {
		boardRepo.updatePDSFile(55L, "파일이름수정.ppt");
	}
	
	//PDSBoard의 이름 변경: 원래 이름 뒤에 pid 붙이기
	//@Test
	void updateBoard() {
		boardRepo.findAll().forEach(board->{
			String name = board.getPname() + "-" + board.getPid();
			board.setPname(name);
			boardRepo.save(board);
		});
	}
	
	//@Test
	void selectBoard5() {
		boardRepo.getFilesCount2().forEach(arr->System.out.println(Arrays.toString(arr)));
	}
	
	//@Test
	void selectBoard4() {
		long pid = 4L;
		List<Object[]> blist = boardRepo.getFilesInfo2(pid);
		blist.forEach(arr->System.out.println(Arrays.toString(arr)));
	}
	
	
	//입력, 수정...board에 file 추가
	//@Test
	void insertBoard() {
		PDSBoardEntity board = boardRepo.findById(4L).orElse(null);
		if (board == null) return;
		List<PDSFileEntity> flist = board.getFiles();
		PDSFileEntity file1 = PDSFileEntity.builder().pdsfilename("파일추가1.jpg").build();
		PDSFileEntity file2 = PDSFileEntity.builder().pdsfilename("파일추가2.jpg").build();
		flist.add(file1);
		flist.add(file2);
		board.setWriter("작성자수정");
		boardRepo.save(board);
	}
	
	//조회
	@Transactional
	//@Test
	void selectBoard3() {
		PDSBoardEntity board = boardRepo.findById(4L).orElse(null);
		if(board==null) return;
			System.out.println(board.getPname());
			System.out.println(board);
			System.out.println(board.getFiles().size() + "건");
	}
	
	//조회
	@Transactional
	//@Test
	void selectBoard2() {
		String writer = "수영";
		List<PDSBoardEntity> blist = boardRepo.findByWriter(writer);
		for(PDSBoardEntity board:blist) {
			System.out.println(board.getPname());
			System.out.println(board);
			System.out.println(board.getFiles().size() + "건");
			System.out.println("-------------------");
		}
	}
	
	
	//조회
	//PDSFileEntity의 pdsfilename으로 조회
	//@Test
	void selectFileByName() {
		String pdsfilename = "파이썬-8-1.ppt";
		PDSFileEntity file = fileRepo.findByPdsfilename(pdsfilename);
		System.out.println(file);
	}
	
	//@Test
	void selectBoard() {
		Long pid = 1L;
		
		PDSBoardEntity board = boardRepo.findById(pid).orElse(null);
		if(board == null) return;
		System.out.println(board);
		System.out.println(board.getPname());
		System.out.println(board.getWriter());
		System.out.println(board.getFiles().size());
		System.out.println(board.getFiles());
	}
	
	//조회
	//@Test
	void selectFile() {
		Long fno = 10L;
		PDSFileEntity file = fileRepo.findById(fno).orElse(null);
		System.out.println(file);
	}
	
	//@Test
	void insert2() {
		IntStream.rangeClosed(1, 10).forEach(j->{
			List<PDSFileEntity> files = new ArrayList<>();
			IntStream.rangeClosed(1, 5).forEach(i->{
				PDSFileEntity file = PDSFileEntity.builder()
						.pdsfilename("파이썬-" + j + "-" + i + ".ppt")
						.build();
				files.add(file);
			});
			PDSBoardEntity board = PDSBoardEntity.builder()
					.pname("파이썬교육")
					.writer("수영")
					.files(files)
					.build();
			boardRepo.save(board);
		});
	}
	
	//@Test
	void insert() {
		List<PDSFileEntity> files = new ArrayList<>();

		IntStream.rangeClosed(1, 5).forEach(i->{
			PDSFileEntity file = PDSFileEntity.builder()
					.pdsfilename("스프링Book-" + i + ".ppt")
					.build();
			files.add(file);
		});
		PDSBoardEntity board = PDSBoardEntity.builder()
				.pname("springboot-JPA")
				.writer("준성")
				.files(files)
				.build();
		
		boardRepo.save(board);
	}
}
