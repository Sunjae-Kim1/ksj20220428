package org.kosta.myproject.model;

import java.sql.Date;

public class TimeTableVO {
	private int timeTableNO;
	private Date showTime;
	private FilmVO filmVO;
	public TimeTableVO() {
		super();
	}
	public TimeTableVO(int timeTableNO, Date showTime, FilmVO filmVO) {
		super();
		this.timeTableNO = timeTableNO;
		this.showTime = showTime;
		this.filmVO = filmVO;
	}
	public int getTimeTableNO() {
		return timeTableNO;
	}
	public void setTimeTableNO(int timeTableNO) {
		this.timeTableNO = timeTableNO;
	}
	public Date getShowTime() {
		return showTime;
	}
	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}
	public FilmVO getFilmVO() {
		return filmVO;
	}
	public void setFilmVO(FilmVO filmVO) {
		this.filmVO = filmVO;
	}
	@Override
	public String toString() {
		return "TimeTableVO [timeTableNO=" + timeTableNO + ", showTime=" + showTime + ", filmVO=" + filmVO + "]";
	}
<<<<<<< HEAD
}  
=======
}
>>>>>>> branch 'main' of https://github.com/Sunjae-Kim1/ksj20220428.git
