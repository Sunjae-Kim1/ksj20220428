package org.kosta.myproject.model;

import java.sql.Date;

public class ScreenVO {
	private int screenNo;
	private Date showTime;
	private SeatVO seatVO;
	private MovieVO movieVO;
	public ScreenVO() {
		super();
	}
	public ScreenVO(int screenNo, Date showTime, SeatVO seatVO, MovieVO movieVO) {
		super();
		this.screenNo = screenNo;
		this.showTime = showTime;
		this.seatVO = seatVO;
		this.movieVO = movieVO;
	}
	public int getScreenNo() {
		return screenNo;
	}
	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}
	public Date getShowTime() {
		return showTime;
	}
	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}
	public SeatVO getSeatVO() {
		return seatVO;
	}
	public void setSeatVO(SeatVO seatVO) {
		this.seatVO = seatVO;
	}
	public MovieVO getMovieVO() {
		return movieVO;
	}
	public void setMovieVO(MovieVO movieVO) {
		this.movieVO = movieVO;
	}
	@Override
	public String toString() {
		return "ScreenVO [screenNo=" + screenNo + ", showTime=" + showTime + ", seatVO=" + seatVO + ", movieVO="
				+ movieVO + "]";
	}
}