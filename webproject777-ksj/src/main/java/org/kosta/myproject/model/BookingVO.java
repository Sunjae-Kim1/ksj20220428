package org.kosta.myproject.model;

import java.util.Date;

public class BookingVO {
	private int bookNo;
	private Date bookTime;
	private String seatNo;
	private MemberVO memberVO;
	private TimeTableVO timeTableVO;
	public BookingVO() {
		super();
	}
	public BookingVO(int bookNo, Date bookTime, String seatNo, MemberVO memberVO, TimeTableVO timeTableVO) {
		super();
		this.bookNo = bookNo;
		this.bookTime = bookTime;
		this.seatNo = seatNo;
		this.memberVO = memberVO;
		this.timeTableVO = timeTableVO;
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
	public String getseatNo() {
		return seatNo;
	}
	public void setseatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public TimeTableVO getTimeTableVO() {
		return timeTableVO;
	}
	public void setTimeTableVO(TimeTableVO timeTableVO) {
		this.timeTableVO = timeTableVO;
	}
	@Override
	public String toString() {
		return "BookingVO [bookNo=" + bookNo + ", bookTime=" + bookTime + ", seatNo=" + seatNo + ", memberVO="
				+ memberVO + ", timeTableVO=" + timeTableVO + "]";
	}
}  