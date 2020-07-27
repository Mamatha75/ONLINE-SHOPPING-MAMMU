package com.dxc.service;

import java.util.List;


import com.dxc.dao.CustomerDao;

import com.dxc.pogos.Cart;
import com.dxc.pogos.CustomerLogin;
import com.dxc.pogos.Product;

public class CustomerService {
	CustomerDao customerdao=new CustomerDao();
	
	public boolean invalidCustomerLogin(int cid, int cpass) {

		return customerdao.invalidCustomerLogin(cid,cpass);
	}

	public List<Product> getAllProduct() {
		
		return customerdao.getAllProduct();
	}

	public boolean findproductId(int pid) {
		
		return customerdao.findproductId(pid);
	}

	public boolean addToCart(int cid, int pid, Product p, Cart cart, int userquantity) {
		
		return customerdao.addToCart(cid,pid,p,cart,userquantity);
	}

	public List<Cart> getAllProductcart(Cart cart, int cid) {
		return customerdao.getAllProductcart(cart,cid);
	}

	public boolean payBill(int cid, int pid, int userquantity, Cart cart) {
		
		return customerdao.payBill(cid,pid,userquantity,cart);
	}

	public boolean addBalance(CustomerLogin c, double addbalance,int cid) {
		return customerdao.addBalance(c,addbalance,cid);
		
		
	}
	

}
