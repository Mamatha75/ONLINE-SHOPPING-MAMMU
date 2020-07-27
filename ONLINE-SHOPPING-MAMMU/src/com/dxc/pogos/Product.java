package com.dxc.pogos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private int pid;
	private String pname;
	private double pprice;
	private int pquantity;
	private int pdiscount;
	
	public Product() {
		
	}

	public Product(int pid, String pname, double pprice, int pquantity, int pdiscount) {
		
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pquantity = pquantity;
		this.pdiscount = pdiscount;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPprice() {
		return pprice;
	}

	public void setPprice(double pprice) {
		this.pprice = pprice;
	}

	public int getPquantity() {
		return pquantity;
	}

	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}

	public int getPdiscount() {
		return pdiscount;
	}

	public void setPdiscount(int pdiscount) {
		this.pdiscount = pdiscount;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pquantity=" + pquantity
				+ ", pdiscount=" + pdiscount + "]";
	}
	
}
