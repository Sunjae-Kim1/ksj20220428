package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class ReviewDAO {
	private static ReviewDAO instance = new ReviewDAO();
	private DataSource dataSource;
	private ReviewDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static ReviewDAO getInstance() {
		return instance;
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close(); // 컨넥션을 컨넥션풀에 반납한다 
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		closeAll(pstmt, con);
	}
	public void posting(ReviewVO vo) throws SQLException {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql ="insert into Review(id,movieNo,star,review) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberVO().getId());
			pstmt.setInt(2, vo.getFilmVO().getFilmNO());
			pstmt.setInt(3, vo.getStar());
			pstmt.setString(4, vo.getReview());
			pstmt.executeUpdate();
		} finally{
			closeAll(pstmt, con);
		}		
	}
	public ArrayList<ReviewVO> findReview(String filmNO) throws SQLException {
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = " select id, movieNo, star, review from review where movieNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(filmNO));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVO rvo = new ReviewVO();
				MemberVO vo = new MemberVO();
				FilmVO fvo = new FilmVO();
				rvo.setStar(rs.getInt(3));
				rvo.setReview(rs.getString(4));
				vo.setId(rs.getString(1));
				rvo.setMemberVO(vo);
				fvo.setFilmNO(rs.getInt(2));
				rvo.setFilmVO(fvo);
				list.add(rvo);
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return list;
	}
}
