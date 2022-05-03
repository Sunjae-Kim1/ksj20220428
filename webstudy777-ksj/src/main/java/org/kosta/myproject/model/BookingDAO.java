package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
}
