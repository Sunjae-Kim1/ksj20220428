package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private DataSource dataSource;
	private MemberDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static MemberDAO getInstance() {
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
	public MemberVO login(String id, String password) throws SQLException {
		MemberVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT name FROM member WHERE id=? AND password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo=new MemberVO(id,rs.getString(1),18,password);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	public void register(MemberVO vo) throws SQLException {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con=dataSource.getConnection();			//dbcp로부터 컨넥션을 빌려온다.
			String sql = "insert into member(id,name,age,password) "
					+ "values (?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getAge());
			pstmt.setString(4, vo.getPassword());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt,con);
		}
		//insert into mvc_member(id,password,name,address,birthday,regdate) values
		//('java','a','아이유','오리',to_date('1993-05-16','yyyy-mm-dd'),sysdate);
	}
	public boolean checkId(String id) throws SQLException {
		boolean result = false;
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con=dataSource.getConnection();			//dbcp로부터 컨넥션을 빌려온다.
			String sql = "SELECT COUNT(*) FROM member WHERE id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()&&rs.getInt(1)==1) {
				result=true;
			}
		}finally {
			closeAll(rs,pstmt,con);
		}
		return result;
	}
}
