package com.dxc.pogos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminLogin {
	@Id
private int aid;
private int apass;
public AdminLogin() {
	
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public int getApass() {
	return apass;
}
public void setApass(int apass) {
	this.apass = apass;
}
@Override
public String toString() {
	return "AdminLogin [aid=" + aid + ", apass=" + apass + "]";
}

}
