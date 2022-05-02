package org.kosta.myproject.model;

import java.sql.Clob;

public class ReviewVO {
	
	private int star;
	private Clob review;
	private FilmVO filmVO;
	private MemberVO memberVO;
	public ReviewVO() {
		super();
	}
	public ReviewVO(int star, Clob review, FilmVO filmVO, MemberVO memberVO) {
		super();
		this.star = star;
		this.review = review;
		this.filmVO = filmVO;
		this.memberVO = memberVO;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public Clob getReview() {
		return review;
	}
	public void setReview(Clob review) {
		this.review = review;
	}
	public FilmVO getFilmVO() {
		return filmVO;
	}
	public void setFilmVO(FilmVO filmVO) {
		this.filmVO = filmVO;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	@Override
	public String toString() {
		return "ReviewVO [star=" + star + ", review=" + review + ", filmVO=" + filmVO + ", memberVO=" + memberVO + "]";
	}
}