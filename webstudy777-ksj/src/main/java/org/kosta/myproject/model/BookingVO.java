package org.kosta.myproject.model;

import java.sql.Date;

public class BookingVO {
	private int bookNo;
	private Date bookTime;
	private ScreenVO screenVO;
	private MemberVO memberVO;
	public BookingVO() {
		super();
	}
	public BookingVO(int bookNo, Date bookTime, ScreenVO screenVO, MemberVO memberVO) {
		super();
		this.bookNo = bookNo;
		this.bookTime = bookTime;
		this.screenVO = screenVO;
		this.memberVO = memberVO;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public Date getBookTime() {
		return bookTime;
	}
	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}
	public ScreenVO getScreenVO() {
		return screenVO;
	}
	public void setScreenVO(ScreenVO screenVO) {
		this.screenVO = screenVO;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	@Override
	public String toString() {
		return "BookingVO [bookNo=" + bookNo + ", bookTime=" + bookTime + ", screenVO=" + screenVO + ", memberVO="
				+ memberVO + "]";
	}
}