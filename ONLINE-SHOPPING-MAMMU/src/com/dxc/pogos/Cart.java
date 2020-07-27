package com.dxc.pogos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
	@Id
	private int sno;
	private int cid;
	private int pid;
	private int pquantity;
	
	private double grandTotal;
	private double totalDiscount;
	private double payableAmount;
	
	
	public Cart() {
		super();
	}


	public Cart(int sno, int cid, int pid, int pquantity, double grandTotal, double totalDiscount,
			double payableAmount) {
		super();
		this.sno = sno;
		this.cid = cid;
		this.pid = pid;
		this.pquantity = pquantity;
		this.grandTotal = grandTotal;
		this.totalDiscount = totalDiscount;
		this.payableAmount = payableAmount;
	}


	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public int getPquantity() {
		return pquantity;
	}


	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}


	public double getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}


	public double getTotalDiscount() {
		return totalDiscount;
	}


	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}


	public double getPayableAmount() {
		return payableAmount;
	}


	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}


	@Override
	public String toString() {
		return "Cart [sno=" + sno + ", cid=" + cid + ", pid=" + pid + ", pquantity=" + pquantity + ", grandTotal="
				+ grandTotal + ", totalDiscount=" + totalDiscount + ", payableAmount=" + payableAmount + "]";
	}
	

	

	
	
}
