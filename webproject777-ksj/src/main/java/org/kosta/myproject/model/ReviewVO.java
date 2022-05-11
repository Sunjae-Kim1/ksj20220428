package org.kosta.myproject.model;

public class ReviewVO {
	
	private float star;
	private String review;
	private FilmVO filmVO;
	private MemberVO memberVO;
	public ReviewVO() {
		super();
	}
	public ReviewVO(float star, String review, FilmVO filmVO, MemberVO memberVO) {
		super();
		this.star = star;
		this.review = review;
		this.filmVO = filmVO;
		this.memberVO = memberVO;
	}
	public float getStar() {
		return star;
	}
	public void setStar(float star) {
		this.star = star;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
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