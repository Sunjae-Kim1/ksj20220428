package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

public class TimeTableDAO {
	private static TimeTableDAO instance = new TimeTableDAO();
	private DataSource dataSource;
	private TimeTableDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static TimeTableDAO getInstance() {
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
			closeAll(rs,pstmt, con);
		}
		return list;
	}
	public String findFilmNameByFilmNo(String filmNo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String filmName =null;
		try {
			con=dataSource.getConnection();
			String sql = "SELECT filmName FROM film WHERE filmNo=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, filmNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				filmName = rs.getString("filmName");
			}
		}finally {
			closeAll(rs,pstmt, con);
		}
		return filmName;
	}
	public ArrayList<String> timeTableMinMax() throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select to_char(sysdate, 'yy-mm-dd') as today, max(showtime) ");
			sql.append("from ( ");
			sql.append("select TO_CHAR(showTime,'yy-mm-dd') as showtime from timetable) ");
			pstmt= con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list.add(rs.getString(1));
				list.add(rs.getString(2));
			}
		}finally {
			closeAll(rs,pstmt, con);
		}
		return list;
	}
	public ArrayList<BookingVO> findBookById(MemberVO mvo) throws SQLException, ParseException {
		ArrayList<BookingVO> list = new ArrayList<BookingVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select bookNo, timeTableNo, seatNo, bookTime from booking where id=? order by bookTime";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TimeTableVO tvo = new TimeTableVO();
				String timeTableNo =rs.getString("timeTableNo");
				ArrayList<String> filmNoShowTimeList = TimeTableDAO.getInstance().findFilmNoShowTimeByTimeTableNo(timeTableNo);
				String filmNo = filmNoShowTimeList.get(0);
				String sShow = filmNoShowTimeList.get(1);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date showTime = format.parse(sShow);
				String filmName = TimeTableDAO.getInstance().findFilmNameByFilmNo(filmNo);				
				int filmNO = Integer.parseInt(filmNo);
				FilmVO fvo = new FilmVO(filmNO, filmName, null);
				tvo.setTimeTableNO(rs.getInt(2));
				tvo.setFilmVO(fvo);
				tvo.setShowTime(showTime);
				BookingVO bvo = new BookingVO();
				bvo.setBookNo(rs.getInt(1));
				String sbookTime =rs.getString(4);
				Date bookTime = format.parse(sbookTime);
				bvo.setBookTime(bookTime);
				bvo.setMemberVO(mvo);
				bvo.setseatNo(rs.getString(3));
				bvo.setTimeTableVO(tvo);				
				list.add(bvo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public ArrayList<String> findFilmNoShowTimeByTimeTableNo(String timeTableNo) throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select filmNo, showTime from timeTable where timeTableNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, timeTableNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				list.add(rs.getString(1));
				list.add(rs.getString(2));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
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
	public String findtimeTableNO(String movieNo, String picktime) throws SQLException {
		String picktimeTableNo = null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=dataSource.getConnection();
			String sql = "select timetableNo from timetable WHERE filmNo=? and showTime= to_date(?, 'yyyy-mm-dd hh24:mi:ss')";
			pstmt= con.prepareStatement(sql.toString());
			pstmt.setString(1, movieNo);
			pstmt.setString(2, picktime);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				picktimeTableNo = rs.getString(1);
			}
		}finally {
			closeAll(rs,pstmt, con);
		}
		return picktimeTableNo;
	}
}
