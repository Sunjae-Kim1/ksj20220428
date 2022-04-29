package org.kosta.myproject.model;

import java.sql.Date;

public class MovieVO {
	private int movieNo;
	private Date openDate;
	private String movieName;
	private int ageLimit;
	private String content;
	private String director;
	private Date producerYear;
	public MovieVO() {
		super();
	}
	public MovieVO(int movieNo, Date openDate, String movieName, int ageLimit, String content, String director,
			Date producerYear) {
		super();
		this.movieNo = movieNo;
		this.openDate = openDate;
		this.movieName = movieName;
		this.ageLimit = ageLimit;
		this.content = content;
		this.director = director;
		this.producerYear = producerYear;
	}
	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Date getProducerYear() {
		return producerYear;
	}
	public void setProducerYear(Date producerYear) {
		this.producerYear = producerYear;
	}
	@Override
	public String toString() {
		return "MovieVO [movieNo=" + movieNo + ", openDate=" + openDate + ", movieName=" + movieName + ", ageLimit="
				+ ageLimit + ", content=" + content + ", director=" + director + ", producerYear=" + producerYear + "]";
	}
}