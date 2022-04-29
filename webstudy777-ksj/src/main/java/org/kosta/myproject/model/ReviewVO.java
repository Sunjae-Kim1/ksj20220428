package org.kosta.myproject.model;

public class ReviewVO {
	
	private int star;
	private String review;
	private MovieVO movieVO;
	private MemberVO memberVO;
	public ReviewVO() {
		super();
	}
	public ReviewVO(int star, String review, MovieVO movieVO, MemberVO memberVO) {
		super();
		this.star = star;
		this.review = review;
		this.movieVO = movieVO;
		this.memberVO = memberVO;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public MovieVO getMovieVO() {
		return movieVO;
	}
	public void setMovieVO(MovieVO movieVO) {
		this.movieVO = movieVO;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	@Override
	public String toString() {
		return "ReviewVO [star=" + star + ", review=" + review + ", movieVO=" + movieVO + ", memberVO=" + memberVO
				+ "]";
	}
}