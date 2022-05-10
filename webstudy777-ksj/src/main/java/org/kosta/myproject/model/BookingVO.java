package org.kosta.myproject.model;

import java.util.Date;

public class BookingVO {
	private int bookNo;
	private Date bookTime;
	private String seatNO;
	private MemberVO memberVO;
	private TimeTableVO timeTableVO;
	public BookingVO() {
		super();
	}
	public BookingVO(int bookNo, Date bookTime, String seatNO, MemberVO memberVO, TimeTableVO timeTableVO) {
		super();
		this.bookNo = bookNo;
		this.bookTime = bookTime;
		this.seatNO = seatNO;
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
	public String getseatNO() {
		return seatNO;
	}
	public void setseatNO(String seatNO) {
		this.seatNO = seatNO;
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
		return "BookingVO [bookNo=" + bookNo + ", bookTime=" + bookTime + ", seatNO=" + seatNO + ", memberVO="
				+ memberVO + ", timeTableVO=" + timeTableVO + "]";
	}
}  