package com.ibm.monitor;

import java.util.Date;

public class Reading {
	private Date timestamp;
	
	private double cur1;
	private double cur2;
	private double cur3;
	private double temp1;
	private double temp2;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public double getCur1() {
		return cur1;
	}
	public void setCur1(double cur1) {
		this.cur1 = cur1;
	}
	public double getCur2() {
		return cur2;
	}
	public void setCur2(double cur2) {
		this.cur2 = cur2;
	}
	public double getCur3() {
		return cur3;
	}
	public void setCur3(double cur3) {
		this.cur3 = cur3;
	}
	public double getTemp1() {
		return temp1;
	}
	public void setTemp1(double temp1) {
		this.temp1 = temp1;
	}
	public double getTemp2() {
		return temp2;
	}
	public void setTemp2(double temp2) {
		this.temp2 = temp2;
	}
	
	
	

}
