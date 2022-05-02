package org.kosta.myproject.model;

import java.sql.Clob;
import java.sql.Date;

public class FilmVO {
	private int movieNO;
	private Clob content;
	private Date openDate;
	private int ageLimit;
	private String director;
	private Date produceYear;
	public FilmVO() {
		super();
	}
	public FilmVO(int movieNO, Clob content, Date openDate, int ageLimit, String director, Date produceYear) {
		super();
		this.movieNO = movieNO;
		this.content = content;
		this.openDate = openDate;
		this.ageLimit = ageLimit;
		this.director = director;
		this.produceYear = produceYear;
	}
	public int getMovieNO() {
		return movieNO;
	}
	public void setMovieNO(int movieNO) {
		this.movieNO = movieNO;
	}
	public Clob getContent() {
		return content;
	}
	public void setContent(Clob content) {
		this.content = content;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public int getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Date getProduceYear() {
		return produceYear;
	}
	public void setProduceYear(Date produceYear) {
		this.produceYear = produceYear;
	}
	@Override
	public String toString() {
		return "FilmVO [movieNO=" + movieNO + ", content=" + content + ", openDate=" + openDate + ", ageLimit="
				+ ageLimit + ", director=" + director + ", produceYear=" + produceYear + "]";
	}
}