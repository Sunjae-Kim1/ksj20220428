package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAO {

	private static MemberDAO instance= new MemberDAO();
	private DataSource dataSource;
	private MemberDAO(){
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static MemberDAO getInstance() {
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
	public MemberVO login(String id, String pw) throws SQLException {
		MemberVO vo = new MemberVO();
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT name FROM member WHERE id = ? AND password =?";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo.setId(id);
				vo.setName(rs.getString("name"));
			}
		}finally {
			closeAll(pstmt, con, rs);
		}
		return vo;
	}
}
