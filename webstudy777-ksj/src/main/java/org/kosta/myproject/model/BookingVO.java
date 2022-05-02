package org.kosta.myproject.model;

import java.sql.Date;

public class BookingVO {
	private int bookNo;
	private Date bookTime;
	private SeatVO seatVO;
	private MemberVO memberVO;
	private TimeTableVO timeTableVO;
	public BookingVO() {
		super();
	}
	public BookingVO(int bookNo, Date bookTime, SeatVO seatVO, MemberVO memberVO, TimeTableVO timeTableVO) {
		super();
		this.bookNo = bookNo;
		this.bookTime = bookTime;
		this.seatVO = seatVO;
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
	public SeatVO getSeatVO() {
		return seatVO;
	}
	public void setSeatVO(SeatVO seatVO) {
		this.seatVO = seatVO;
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
		return "BookingVO [bookNo=" + bookNo + ", bookTime=" + bookTime + ", seatVO=" + seatVO + ", memberVO="
				+ memberVO + ", timeTableVO=" + timeTableVO + "]";
	}
}