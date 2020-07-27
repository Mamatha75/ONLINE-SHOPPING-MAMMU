package com.dxc.pogos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerLogin {
	@Id
	private int cid;
	private int cpass;
	private double balance;
	
	public CustomerLogin() {
		super();
	}
	public CustomerLogin(int cid, int cpass, double balance) {
		super();
		this.cid = cid;
		this.cpass = cpass;
		this.balance = balance;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCpass() {
		return cpass;
	}
	public void setCpass(int cpass) {
		this.cpass = cpass;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "CustomerLogin [cid=" + cid + ", cpass=" + cpass + ", balance=" + balance + "]";
	}
	
	
	
}
