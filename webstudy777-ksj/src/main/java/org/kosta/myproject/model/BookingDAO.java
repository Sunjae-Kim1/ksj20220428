package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BookingDAO {
	private static BookingDAO instance = new BookingDAO();
	private DataSource dataSource;
	private BookingDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static BookingDAO getInstance() {
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
	public void booking(String picktimeNo, String id, String pickseat) throws SQLException {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con=dataSource.getConnection();			//dbcp로부터 컨넥션을 빌려온다.
			String sql = "insert into booking(bookNo, timetableNo, id, seatNo, bookTime) values(booking_seq.nextval, ?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, picktimeNo);
			pstmt.setString(2, id);
			pstmt.setString(3, pickseat);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt,con);
		}
		
	}
	public ArrayList<String> duplicateFilm(String timetableNo) throws SQLException {
		ArrayList<String> dupl = new ArrayList<String>() ;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=dataSource.getConnection();
			String sql = "select seatNo from booking where timetableNo = ?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, timetableNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dupl.add(rs.getString(1));
			}
		}finally {
			closeAll(rs,pstmt, con);
		}
		return dupl;
	}
	public void cancleBook(String bookNo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql = "delete booking where bookNo=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, bookNo);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	
}
