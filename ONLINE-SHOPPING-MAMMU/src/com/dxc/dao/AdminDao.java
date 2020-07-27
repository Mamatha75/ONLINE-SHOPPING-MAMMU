package com.dxc.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pogos.AdminLogin;
import com.dxc.pogos.CustomerLogin;
import com.dxc.pogos.Product;

public class AdminDao {
private static SessionFactory sessionFactory;
	
	static{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	public boolean invalidAdminLogin(int aid, int apass) {
		Session session=sessionFactory.openSession();
		
		Query query=session.createQuery("from AdminLogin");
		System.out.println("helloo");
		List<AdminLogin> list=query.getResultList();

		for (AdminLogin l : list) {
			l.getAid();
			l.getApass();
			if(aid==l.getAid() && apass==l.getApass()) {
			return true;
			}
		}
		return false;
				
			}
	public void addProduct(Product p) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}
	public List<Product> getAllProduct() {
		 Session session=sessionFactory.openSession(); 
		  Query query=session.createQuery("from Product");
		  return query.getResultList();
	}
	public void addcust(CustomerLogin c) {
		 System.out.println("add account");
		 Session session=sessionFactory.openSession(); 
		 session.beginTransaction();
		 session.save(c); 
		 session.getTransaction().commit();
		 System.out.println("after add account");
		
	}
	public boolean removecust(int cid) {
		 Session session=sessionFactory.openSession();
		 session.beginTransaction();
		  Query query=session.createQuery("delete from CustomerLogin where cid=:cid");
		  query.setParameter("cid", cid); 
		  query.executeUpdate();
		  session.getTransaction().commit(); 
		  return true;
	}
	public List<CustomerLogin> getAllCustomer() {
		 Session session=sessionFactory.openSession(); 
		  Query query=session.createQuery("from CustomerLogin");
		  return query.getResultList();
	}

}
