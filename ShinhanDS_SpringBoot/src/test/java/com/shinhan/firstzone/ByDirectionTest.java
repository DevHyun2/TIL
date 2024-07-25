//package com.shinhan.firstzone;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.IntStream;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.shinhan.firstzone.repository3.FreeBoardRepository;
//import com.shinhan.firstzone.repository3.FreeReplyRepository;
//import com.shinhan.firstzone.vo3.FreeBoardEntity;
//import com.shinhan.firstzone.vo3.FreeReplyEntity;
//
////@SpringBootTest
//public class ByDirectionTest {
//	
//	@Autowired
//	FreeBoardRepository boardRepo;
//	@Autowired
//	FreeReplyRepository replyRepo;
//	
//	//@Test
//	void insertBoard() {
//		//30건
//		IntStream.rangeClosed(1, 30).forEach(i->{
//			FreeBoardEntity entity = FreeBoardEntity.builder()
//					.title("수요일" + i)
//					.content("오늘 날씨는" + (i%2==0?"맑읆":"비"))
//					.writer("user" + i%5)
//					.build();
//			boardRepo.save(entity);
//		});
//	}
//	
//	//특정board의 댓글삽입
//	//@Test
//	void insertBoard2() {
//		boardRepo.findById(3L).ifPresent(board->{
//			List<FreeReplyEntity> replyList = board.getReplies();
//			IntStream.rangeClosed(1, 10).forEach(i->{
//				FreeReplyEntity reply = FreeReplyEntity.builder()
//						.reply("댓글ver3...." + i)
//						.replyer("user" + i)
//						.board(board)
//						.build();
//				replyList.add(reply);
//			});
//			boardRepo.save(board);
//		});
//	}
//	
//	//댓글삽입
//	//@Test
//	void insertReply() {
//		FreeBoardEntity board = FreeBoardEntity.builder().bno(4L).build();
//		FreeReplyEntity reply = FreeReplyEntity.builder()
//				.reply("점메추")
//				.replyer("user1")
//				.board(board)
//				.build();
//		replyRepo.save(reply);
//	}
//	
//	//댓글수정
//	//@Test
//	void updateReply() {
//		FreeBoardEntity board = FreeBoardEntity.builder().bno(4L).build();
//		Long[] arr = {20L, 21L, 22L, 23L, 24L};
//		List<Long> idList = Arrays.asList(arr);
//		replyRepo.findAllById(idList).forEach(reply->{
//			reply.setBoard(board);
//			replyRepo.save(reply);
//		});
//	}
//	
//	//board번호를 알고 댓글들의 정보조회, toString 중복으로 Overflow
//	//@Test
//	void selectByReply() {
//		FreeBoardEntity board = FreeBoardEntity.builder().bno(5L).build();
//		replyRepo.findByBoard(board).forEach(reply->System.out.println(reply));
//	}
//	
//	//@Test
//	void join1() {
//		//boardRepo.findAllWithReplyByUsingJoin().forEach(b->System.out.println(b));
//		boardRepo.findAllWithReplyByUsingJoinFetch().forEach(b->System.out.println(b));
//	}
//	
//	//@Test
//	void join2() {
//		//replyRepo.findAllWithReplyByUsingJoin().forEach(b->System.out.println(b));
//		replyRepo.findAllWithReplyByUsingJoinFetch().forEach(b->System.out.println(b));
//	}
//}
