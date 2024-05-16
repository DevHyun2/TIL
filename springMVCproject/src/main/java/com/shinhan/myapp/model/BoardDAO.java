package com.shinhan.myapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bDAO") //== @Component(Bean) + DAO ?—­?• 
public class BoardDAO {
	
	@Autowired
	DataSource ds;
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs; //ì¡°íšŒ?• ?•Œ
	int result;
	
	//? „ì²´ì¡°?šŒ
	public List<BoardDTO> selectAll() {
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		String sql = "select * from TBL_BOARD order by 1 desc";
		try {
			conn = ds.getConnection();
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
			//DBUtil.dbDisconnect(conn, st, rs);
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
	
	//?•œê±´ì¡°?šŒ
	public BoardDTO selectById(int bno) {
		BoardDTO board = null;
		
		String sql = "select * from TBL_BOARD where bno = ?";
		try {
			conn = ds.getConnection();
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
			//DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return board;
	}
	//?ž…? ¥
	public int insertBoard(BoardDTO board) {
		String sql = "insert into TBL_BOARD(bno, title, content, writer, pic) "
					+ "values(seq_board_bno.nextval,?,?,?,?)";
		try {
			conn = ds.getConnection();
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
			//DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}
	
	//?ˆ˜? •
	public int updateBoard(BoardDTO board) {
		String sql = "update TBL_BOARD set title=?, content=?, pic=? "
					+ "where bno=?";
		try {
			conn = ds.getConnection();
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
			//DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}
	
	//?‚­? œ
	public int deleteBoard(int bno) {
		String sql = "delete from TBL_BOARD where bno = ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, bno);
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}
}
