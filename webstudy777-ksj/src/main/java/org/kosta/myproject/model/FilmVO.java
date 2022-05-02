package org.kosta.myproject.model;

import java.sql.Date;

public class FilmVO {
	private int filmNO;
	private String filmName;
	private String content;
	private Date openDate;
	private int ageLimit;
	private String director;
	private Date produceYear;
	public FilmVO() {
		super();
	}
	public FilmVO(int filmNO, String filmName, String content, Date openDate, int ageLimit, String director,
			Date produceYear) {
		super();
		this.filmNO = filmNO;
		this.filmName = filmName;
		this.content = content;
		this.openDate = openDate;
		this.ageLimit = ageLimit;
		this.director = director;
		this.produceYear = produceYear;
	}
	public int getFilmNO() {
		return filmNO;
	}
	public void setFilmNO(int filmNO) {
		this.filmNO = filmNO;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
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
		return "FilmVO [filmNO=" + filmNO + ", filmName=" + filmName + ", content=" + content + ", openDate=" + openDate
				+ ", ageLimit=" + ageLimit + ", director=" + director + ", produceYear=" + produceYear + "]";
	}
}