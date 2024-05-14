package com.shinhan.myapp.section4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository //== @Component(Bean) + DAO 역할
public class BoardDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs; //조회할때
	int result;
	
	//전체조회
	public List<BoardDTO> selectAll() {
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		conn = DBUtil.dbConnection();
		String sql = "select * from TBL_BOARD order by 1 desc";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BoardDTO board = makeBoard(rs);
				boardList.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return boardList;
	}

	private BoardDTO makeBoard(ResultSet rs2) throws SQLException {
		BoardDTO board = new BoardDTO();
		board.setBno(rs.getInt("bno"));
		board.setContent(rs.getString("content"));
		board.setCreate_date(rs.getDate("create_date"));
		board.setPic(rs.getString("pic"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		
		return board;
	}
	
	//한건조회
	public BoardDTO selectById(int bno) {
		BoardDTO board = null;
		conn = DBUtil.dbConnection();
		String sql = "select * from TBL_BOARD where bno = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, bno);
			rs = pst.executeQuery();
			while(rs.next()) {
				board = makeBoard(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return board;
	}
	//입력
	public int insertBoard(BoardDTO board) {
		conn = DBUtil.dbConnection();
		String sql = "insert into TBL_BOARD(bno, title, content, writer, pic) "
					+ "values(seq_board_bno.nextval,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setString(3, board.getWriter());
			pst.setString(4, board.getPic());
			rs = pst.executeQuery();
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}
	
	//수정
	public int updateBoard(BoardDTO board) {
		conn = DBUtil.dbConnection();
		String sql = "update TBL_BOARD set title=?, content=?, pic=? "
					+ "where bno=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setString(3, board.getPic());
			pst.setInt(4, board.getBno());
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}
	
	//삭제
	public int deleteBoard(int bno) {
		conn = DBUtil.dbConnection();
		String sql = "delete from TBL_BOARD where bno = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, bno);
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}
}
