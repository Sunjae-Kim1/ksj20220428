package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class FilmDAO {
	private static FilmDAO instance= new FilmDAO();
	private DataSource dataSource;
	private FilmDAO(){
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static FilmDAO getInstance() {
		return instance;
	}
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException{
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public void closeAll(PreparedStatement pstmt, Connection con, ResultSet rs) throws SQLException{
		if(rs!=null)
			rs.close();
		closeAll(pstmt, con);
	}
	public FilmVO filmDetail(String filmNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FilmVO fvo = new FilmVO();
		try {
			con= dataSource.getConnection();
			String sql = "SELECT * FROM film WHERE filmNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, filmNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				fvo.setAgeLimit(rs.getInt("ageLimit"));
				fvo.setContent(rs.getString("content"));
				fvo.setDirector(rs.getString("director"));
				fvo.setFilmName(rs.getString("filmName"));
				fvo.setFilmNO(rs.getInt("filmNo"));
				fvo.setOpenDate(rs.getDate("openDate"));
				fvo.setProduceYear(rs.getDate("produceYear"));
			}
		}finally {
			closeAll(pstmt, con, rs);
		}
		return fvo;
	}
	public FilmVO findFilmByName(String filmName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FilmVO fvo = new FilmVO();
		try {
			con= dataSource.getConnection();
			String sql = "SELECT * FROM film WHERE filmName = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, filmName);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				fvo = FilmDAO.getInstance().filmDetail(rs.getString("filmNo"));
				
			}
		}finally {
			closeAll(pstmt, con, rs);
		}
		
		return fvo;
	}
	public ArrayList<FilmVO> filmList() throws SQLException{
		ArrayList<FilmVO> list = new ArrayList<FilmVO>();
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		FilmVO fvo = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM film";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				fvo = new FilmVO();
				fvo.setAgeLimit(rs.getInt("ageLimit"));
				fvo.setContent(rs.getString("content"));
				fvo.setDirector(rs.getString("director"));
				fvo.setFilmName(rs.getString("filmName"));
				fvo.setFilmNO(rs.getInt("filmNo"));
				fvo.setOpenDate(rs.getDate("openDate"));
				fvo.setProduceYear(rs.getDate("produceYear"));
				list.add(fvo);
			}
		}finally {
			closeAll(pstmt, con, rs);
		}
		return list;
	}
}
