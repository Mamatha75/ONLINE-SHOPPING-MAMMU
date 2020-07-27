package com.dxc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.pogos.AdminLogin;
import com.dxc.pogos.CustomerLogin;
import com.dxc.pogos.Product;
import com.dxc.service.AdminService;
@Controller
@RequestMapping("/views")
public class AdminController {
	AdminService service=new AdminService();
	@RequestMapping("/admin")
	public String adminLogin(@ModelAttribute AdminLogin a,Model m) {
        int aid=a.getAid();
		int apass=a.getApass();
		 boolean
		 find=service.invalidAdminLogin(aid, apass);
		 if(find)
		 { 
			 return "adminmenu"; 
		 }
		 else { String msg; msg="INVALID ADMINID AND ADMINPASSWORD !";
		 m.addAttribute("msg", msg); 
		 return "message"; 
		 } 
		 }
	
	@RequestMapping("/addproduct")
	public String addProduct(@ModelAttribute Product p,Model m)
	{
		service.addProduct(p);
		String msg;
		msg="PRODUCT ADDED SUCCESSUFULLY !";
		m.addAttribute("msg", msg);
		return "message";
	}
  @RequestMapping("/show") 
	  
	  public String getAllProduct(Model model) {
		  System.out.println("---------------------");
	  List<Product> list=service.getAllProduct(); 
	  model.addAttribute("list", list);
	  return "show";
	  }
 
  @RequestMapping("/addcustomer")
  public String addcust(@ModelAttribute CustomerLogin c,Model m)
     {
	 
  	service.addcust(c);
		String msg="CUSTOMER ACCOUNT ADDED SUCCESSFULLY!";
		m.addAttribute("msg", msg);
		return "message";
		 }
  @RequestMapping("/showallcustomer") 
		  
		  public String getAllcustomer(Model model) {
			  System.out.println("---------------------");
		  List<CustomerLogin> list=service.getAllCustomer(); 
		  model.addAttribute("list", list);
		  return "showallcustomer";
		  }
  @RequestMapping("/removecustomer")
  public String removecust(@ModelAttribute CustomerLogin c,Model m)
     {
	  int cid=c.getCid();
  	boolean status=service.removecust(cid);
  	if(status==true) {
  		String msg="account removed !";
  		m.addAttribute("msg", msg);
	    	return "message";
			 }
  	else {
  		String msg="account unavailable !";
  		m.addAttribute("msg", msg);
	    	return "message";
			
  	}
     }
  
}
