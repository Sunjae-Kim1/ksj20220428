package org.kosta.myproject.model;

public class SeatVO {
	private int seatNo;
	private int Xseat;
	private String Yseat;
	public SeatVO() {
		super();
	}
	public SeatVO(int seatNo, int xseat, String Yseat) {
		super();
		this.seatNo = seatNo;
		Xseat = xseat;
		this.Yseat = Yseat;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public int getXseat() {
		return Xseat;
	}
	public void setXseat(int xseat) {
		Xseat = xseat;
	}
	public String getYseat() {
		return Yseat;
	}
	public void setYseat(String Yseat) {
		this.Yseat = Yseat;
	}
	@Override
	public String toString() {
		return "SeatVO [seatNo=" + seatNo + ", Xseat=" + Xseat + ", Yseat=" + Yseat + "]";
	}
}