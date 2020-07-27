package com.dxc.controllers;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pogos.AdminLogin;

import com.dxc.pogos.Cart;
import com.dxc.pogos.CustomerLogin;
import com.dxc.pogos.Product;
import com.dxc.service.AdminService;
import com.dxc.service.CustomerService;
@Controller
@RequestMapping("/views")
public class CustomerController {
	CustomerService service=new CustomerService();
	@RequestMapping("/customer")
	public String adminLogin(@ModelAttribute CustomerLogin c,HttpSession session,Model m) {
		int cid=c.getCid();
		session.setAttribute("cid", cid);
		int cpass=c.getCpass();
		boolean find=service.invalidCustomerLogin(cid, cpass);
		if(find)
		{ 
			return "customermenu"; 
		}
		else {
			String msg; msg="INVALID CUSTOMERID AND CUSTOMER PASSWORD !";
			m.addAttribute("msg", msg); 
			return "message"; 
		}
	}

	@RequestMapping("c/show") 

	public String getAllProduct(Model model,HttpSession session) {
		System.out.println("---------------------");
		List<Product> list=service.getAllProduct(); 
		session.setAttribute("list", list);
		model.addAttribute("list", list);
		return "show";
	}
	@RequestMapping("/find")
	public String addProduct(@ModelAttribute Product p,HttpSession session,Model m)
	{
		int pid=p.getPid();
		session.setAttribute("pid",pid);
		boolean status=true;
		status=service.findproductId(pid);
		System.out.println("------------------");
		String msg;

		if(status==false)
		{
			msg="PRODUCT NOT FOUND!";
			m.addAttribute("msg", msg);
			return "message";
		}
		else 
		{
			return "enterquantity";
		}
	}

	// pid cid; 1.pid=1 -- data | pid=1-quan 3 | pid=1,Gtot=cost*quan | APrice=totalprice-discount |dis=10/100|Tdis=Gtot*dis
	@RequestMapping("/addtocart")
	public String addToCart(@ModelAttribute Product p,@ModelAttribute Cart cart,HttpSession session,@RequestParam ("pquantity") int userquantity,Model m)
	{

		int cid=(int)session.getAttribute("cid");
		int pid=(int)session.getAttribute("pid");
		session.setAttribute("userquantity",userquantity);

		System.out.println("before add to cart");
		boolean b=service.addToCart(cid,pid,p,cart,userquantity);
		System.out.println("after add to cart");
		String msg;
		if(b==true) {
			msg="PRODUCT ADDED TO THE CART !";
		}
		else {
			msg="PRODUCT NOT ADDED TO THE CART !"; 
		}

		m.addAttribute("msg", msg);
		return "message";	
	}

	@RequestMapping("showcart") 

	public String getAllProductcart(@ModelAttribute Cart cart,Model model,HttpSession session) {
		System.out.println("---------------------");
		int cid=(int)session.getAttribute("cid");
		List<Cart> list=service.getAllProductcart(cart,cid); 
		session.setAttribute("list", list);
		model.addAttribute("list", list);
		return "showcart";
	}
	@RequestMapping("/paybill")
	public String getPayBill(@ModelAttribute Cart cart,Model model,HttpSession session) {
	
		int cid=(int) session.getAttribute("cid");
		int pid=(int) session.getAttribute("pid");
	int userquantity=(int) session.getAttribute("userquantity");
		
		boolean b=service.payBill(cid,pid,userquantity,cart);
		String msg;
		if(b==true)
		{
		msg="bill payment successsfull";
		}
		else
		{
			msg="bill payment unsuccesssfull";
		}
		model.addAttribute("msg",msg);
		
	
	return "message";
	}
	@RequestMapping("/addbalance")
	public String addBalnce(@RequestParam ("addbalance") double addbalance,Model model,HttpSession session,@ModelAttribute CustomerLogin c) {
		int cid=(int) session.getAttribute("cid");
		boolean b=service.addBalance(c,addbalance,cid);
		String msg;
		if(b==true) {
			msg="BALANCE ADDED TO THE CUSTOMER ACCOUNT !";
		}
		else {
			msg="BALANCE NOT ADDED TO THE CUSTOMER ACCOUNT !!"; 
		}

		model.addAttribute("msg", msg);
		return "message";	
	
	}

	
	}

