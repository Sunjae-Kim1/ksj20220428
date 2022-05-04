package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

public class BookingDAO {
	private static BookingDAO instance= new BookingDAO();
	private DataSource dataSource;
	private BookingDAO(){
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static BookingDAO getInstance() {
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
	public ArrayList<String> pickBookTime(String filmNo) throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=dataSource.getConnection();
			String sql = "SELECT showTime FROM timetable WHERE filmNo=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, filmNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		}finally {
			closeAll(pstmt, con, rs);
		}
		return list;
	}
	public ArrayList<String> timeTableMinMax() throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select min(showtime), max(showtime) ");
			sql.append("from ( ");
			sql.append("select TO_CHAR(showTime,'yy-mm-dd') as showtime from timetable) ");
			pstmt= con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list.add(rs.getString(1));
				list.add(rs.getString(2));
			}
		}finally {
			closeAll(pstmt, con, rs);
		}
		return list;
	}
	public ArrayList<HashMap<String, String>> findBookTimeByDay(String filmNo, String day) throws SQLException {
		ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select to_char(showtime, 'hh24:mi:ss') ");
			sql.append("from TIMETABLE ");
			sql.append("where filmNo=? and to_char(showtime, 'yy-mm-dd')=? ");
			pstmt= con.prepareStatement(sql.toString());
			pstmt.setString(1, filmNo);
			pstmt.setString(2, day);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				map.put(filmNo, rs.getString(1));
				arrayList.add(map);
			}
		}finally {
			closeAll(pstmt, con, rs);
		}
		return arrayList;
	}
	
	
}
