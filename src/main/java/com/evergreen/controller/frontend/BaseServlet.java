package com.evergreen.controller.frontend;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.evergreen.utilities.HibernateHelper;

public abstract class BaseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected Session session;
	protected Transaction tx;
	
	@Override
	public void init() throws ServletException{
		session = HibernateHelper.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	@Override
	public void destroy(){
		tx.commit();
		session.close();
	}
}
