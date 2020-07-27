package com.dxc.service;

import java.util.List;

import com.dxc.dao.AdminDao;
import com.dxc.pogos.CustomerLogin;
import com.dxc.pogos.Product;

public class AdminService {

	AdminDao adminDao=new AdminDao();
	public boolean invalidAdminLogin(int aid, int apass) {
		
		return adminDao.invalidAdminLogin(aid,apass);
	}
	public void addProduct(Product p) {
		adminDao.addProduct(p);
		
	}
	public List<Product> getAllProduct() {
		
		return adminDao.getAllProduct();
	}
	public void addcust(CustomerLogin c) {
		adminDao.addcust(c);
		
	}
	public boolean removecust(int cid) {
		
		return adminDao.removecust(cid);
	}
	public List<CustomerLogin> getAllCustomer() {
		
		return adminDao.getAllCustomer();
	}

}
