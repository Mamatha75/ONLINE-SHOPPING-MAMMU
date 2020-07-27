package com.dxc.dao;

import java.util.List;



import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pogos.AdminLogin;
//import com.dxc.pogos.Cart;
import com.dxc.pogos.Cart;
import com.dxc.pogos.CustomerLogin;
import com.dxc.pogos.Product;


public class CustomerDao {
	private static SessionFactory sessionFactory;

	static{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}

	public boolean invalidCustomerLogin(int cid, int cpass) {
		Session session=sessionFactory.openSession();

		Query query=session.createQuery("from CustomerLogin");
		System.out.println("helloo");
		List<CustomerLogin> list=query.getResultList();

		for (CustomerLogin l : list) {
			l.getCid();
			l.getCpass();
			if(cid==l.getCid() && cpass==l.getCpass()) {
				return true;
			}
		}
		return false;
	}

	public List<Product> getAllProduct() {
		Session session=sessionFactory.openSession(); 
		Query query=session.createQuery("from Product");
		return query.getResultList();
	}

	public boolean findproductId(int pid) {
		Product v=null;
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where pid=:pid");
		query.setParameter("pid", pid);
		List<Product> v1=query.getResultList();
		try {
			v=v1.get(0);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean addToCart(int cid, int pid, Product p, Cart cart, int userquantity) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query1 = session.createQuery("from Product where pid=:pid");
		query1.setParameter("pid", pid);
		List<Product> list = query1.getResultList();
		System.out.println(list);



		Product p1 = list.get(0);
		if (p1.getPquantity() >= userquantity) {



			double discount = p1.getPprice() / p1.getPdiscount();
			double grandtotal = userquantity * p1.getPprice(); 
			double totdiscount = (userquantity * discount) * 2;
			double payableAmount = grandtotal - totdiscount;



			// "discount" value="${product.getDiscount() / 100}"
			// "grandTotal" value="${price * quantity}"
			// "totalDiscount" value="${grandTotal * (discount)}
			// ="payableAmount" value="${grandTotal - totalDiscount}"



			cart.setCid(cid);
			cart.setPid(p1.getPid());
			cart.setPquantity(userquantity);
			cart.setGrandTotal(grandtotal);
			cart.setTotalDiscount(totdiscount);
			cart.setPayableAmount(payableAmount);
			Session session1 = sessionFactory.openSession();
			session1.beginTransaction();
			session1.save(cart);
			session1.getTransaction().commit();
             // session.close();
			// session1.close();
			return true;
		}
		return false;



	}



	public List<Cart> getAllProductcart(Cart cart, int cid) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where cid=:cid");
		query.setParameter("cid", cid);
		List<Cart> list = query.getResultList();
		for (Cart c : list) {
			if (c.getCid() == cid) {
				return query.getResultList();
			}
		}
		return null;
	}

	public boolean payBill(int cid, int pid, int userquantity, Cart cart) {
		
		int u = 0;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Product where pid=:pid");
		query.setParameter("pid", pid);



		List<Product> list = query.getResultList();
		for (Product p : list) {
			u = p.getPquantity() - userquantity;
			Query query1 = session.createQuery("update Product set Pquantity=:Pquantity where pid=:pid ");
			query1.setParameter("pid", pid);
			query1.setParameter("Pquantity", u);
			query1.executeUpdate();
		}
		session.getTransaction().commit();



		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		Query query2 = session1.createQuery("from CustomerLogin where cid=:cid");
		query2.setParameter("cid", cid);



		List<CustomerLogin> list1 = query2.getResultList();
		double bal = 0;
		for (CustomerLogin c : list1) {
			Session session3 = sessionFactory.openSession();
			session3.beginTransaction();
			Query query5 = session3.createQuery("from Cart where cid=:cid and pid=:pid");
			query5.setParameter("cid", cid);
			query5.setParameter("pid", pid);
			List<Cart> l1 = query5.getResultList();
			for (Cart c1 : l1) {

				if (c.getBalance() >= c1.getPayableAmount()) {



					bal = c.getBalance() - c1.getPayableAmount();
					Query query3 = session1.createQuery("update CustomerLogin set balance=:bal where cid=:cid ");
					query3.setParameter("cid", cid);
					query3.setParameter("bal", bal);
					query3.executeUpdate();

					//    return true;

				}
				else {
					return false;
				}
			}
			session3.getTransaction().commit();
		}
		session1.getTransaction().commit();

        Session session2 = sessionFactory.openSession();
		System.out.println("Entered session");
		session2.beginTransaction();
		Query query3 = session2.createQuery("delete from Cart where cid=:cid AND pid=:pid");
		query3.setParameter("cid", cid);
		query3.setParameter("pid", pid);
		query3.executeUpdate();
		session2.getTransaction().commit();

        return true;
	}

	

	public boolean addBalance(CustomerLogin c, double addbalance, int cid) {
		 Session session = sessionFactory.openSession();
			
			session.beginTransaction();
					
			Query query= session.createQuery("from CustomerLogin where cid=:cid");
		query.setParameter("cid", cid);
		//double custbal=c.getBalance();
		
		double bal=0;
		List<CustomerLogin> list = query.getResultList();
		for (CustomerLogin c1 : list) {
			bal=c1.getBalance()+addbalance;
             System.out.println(bal);
			Query query1= session.createQuery("update CustomerLogin set balance=:bal where cid=:cid ");
			query1.setParameter("cid", cid);
			query1.setParameter("bal", bal);
			query1.executeUpdate();
			
		}
		session.getTransaction().commit();
		return true;
	}
	
	
}




























