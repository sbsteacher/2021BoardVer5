package com.koreait.board5.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;

public class BoardDAO {
	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT "
				+ "	A.iboard, A.title, A.iuser, A.regdt "
				+ "	, B.unm "
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " ORDER BY iboard DESC ";		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();			
			while(rs.next()) {
				BoardVO vo = new BoardVO();								
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
				list.add(vo);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	public static BoardVO selBoard(BoardVO param) {
		BoardVO result = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT B.unm "
				+ "	, A.iboard, A.title, A.ctnt, A.iuser, A.regdt "
				+ " , if(C.iboard IS NULL, 0, 1) AS isFav "				
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				
				+ " LEFT JOIN t_board_fav C "
				+ " ON A.iboard = C.iboard "
				+ " AND C.iuser = ? "
				
				+ " WHERE A.iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIuser()); //로그인 user PK
			ps.setInt(2, param.getIboard());
			
			rs = ps.executeQuery();			
			if(rs.next()) {
				result = new BoardVO();
				result.setIboard(rs.getInt("iboard"));
				result.setTitle(rs.getString("title"));
				result.setCtnt(rs.getString("ctnt"));
				result.setRegdt(rs.getString("regdt"));
				result.setIuser(rs.getInt("iuser"));
				result.setUnm(rs.getString("unm"));
				result.setIsFav(rs.getInt("isFav"));
			}			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
}








