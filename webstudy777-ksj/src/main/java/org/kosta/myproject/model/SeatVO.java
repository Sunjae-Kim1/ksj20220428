package org.kosta.myproject.model;

public class SeatVO {
	private int seatNo;
	private int Xseat;
	private int Yseat;
	public SeatVO() {
		super();
	}
	public SeatVO(int seatNo, int Xseat, int Yseat) {
		super();
		this.seatNo = seatNo;
		this.Xseat = Xseat;
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
	public void setXseat(int Xseat) {
		this.Xseat = Xseat;
	}
	public int getYseat() {
		return Yseat;
	}
	public void setYseat(int Yseat) {
		this.Yseat = Yseat;
	}
	@Override
	public String toString() {
		return "SeatVO [seatNo=" + seatNo + ", Xseat=" + Xseat + ", Yseat=" + Yseat + "]";
	}
}