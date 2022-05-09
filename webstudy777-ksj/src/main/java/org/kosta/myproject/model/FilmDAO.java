package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class FilmDAO {
	private static FilmDAO instance = new FilmDAO();
	private DataSource dataSource;
	private FilmDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static FilmDAO getInstance() {
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
	public ArrayList<ReviewVO> findPostList(Pagination pagination) throws SQLException {
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select nvl(AVG(star),0), filmNo,filmName from(select r.star, f.filmNo, f.filmName from review r "
					+ "right outer join film f on r.movieNo=f.filmNo) where filmNo between ? and ? group by filmNo, filmName "
					+ "order by filmNo asc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pagination.getStartRowNumber());
			pstmt.setInt(2, pagination.getEndRowNumber());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVO vo = new ReviewVO(rs.getInt(1),null,new FilmVO(rs.getInt(2),rs.getString(3),null),null);
				//vo = new PostVO(rs.getInt(1),rs.getString(2),null,rs.getInt(5),rs.getString(4),new MemberVO(null,null,rs.getString(3)));
				list.add(vo);
			}
		}finally{
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	public FilmVO findPostByNo(String no) throws SQLException {
		FilmVO vo = new FilmVO();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT filmNO,filmName,content,openDate,ageLimit,director,produceYear FROM film WHERE filmNO =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {				
				vo.setFilmNO(rs.getInt(1));
				vo.setFilmName(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setOpenDate(rs.getDate(4));
				vo.setAgeLimit(rs.getInt(5));
				vo.setDirector(rs.getString(6));
				vo.setProduceYear(rs.getDate(7));
			}
		} finally{
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	
	/*
	public void posting(FilmVO vo) throws SQLException {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql ="insert into board(board_no,title,content,time_posted,id) values(board_seq.nextval,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getMemberVO().getId());
			pstmt.executeUpdate();
		} finally{
			closeAll(pstmt, con);
		}
		//insert into board(board_no,title,content,time_posted,id) values(board_seq.nextval,?,?,sysdate,?);
	}
	*/
	/*
	public void updateHits(String no) throws SQLException {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql ="UPDATE board SET hits =hits+1 WHERE board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.executeUpdate();
		} finally{
			closeAll(pstmt, con);
		}
	}
	*/
	/*
	public void deletePostByNo(String no) throws SQLException {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql ="DELETE FROM board where board_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.executeUpdate();
		} finally{
			closeAll(pstmt, con);
		}
	}
	*/
	/*
	public void updatePost(FilmVO vo) throws SQLException {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql ="UPDATE board SET title =?, content=?,time_posted=sysdate WHERE  board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNo());
			System.out.println(vo);
			pstmt.executeUpdate();
		} finally{
			closeAll(pstmt, con);
		}
		//UPDATE board SET title = '듀얼', content='리스트',time_posted=sysdate WHERE  board_no = '1';
	}
	*/
	public int getTotalPostCount() throws SQLException {
		int totalPostCount = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from film";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalPostCount=rs.getInt(1);
			}
		} finally{
			closeAll(rs, pstmt, con);
		}
		return totalPostCount;
	}
}
