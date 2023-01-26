package com.evergreen.dao;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.evergreen.utilities.HibernateHelper;

public class UserDaoTest {

	Session session;
	Transaction tx;
	UserDao dao;
	
	@Test
	public void testCheckLoginSuccess() {
		session = HibernateHelper.getSessionFactory().openSession();
		tx = session.beginTransaction();
		dao = new UserDao(session);
		
		String email = "peter@gmail.com";
		String pwd = "peter";
		boolean loginResult = dao.checkLogin(email, pwd);
		assertTrue(loginResult);
	}
	
	@Test
	public void testCheckLoginFail() {
		session = HibernateHelper.getSessionFactory().openSession();
		tx = session.beginTransaction();
		dao = new UserDao(session);
		
		String email = "peter@gmail.com";
		String pwd = "peterr";
		boolean loginResult = dao.checkLogin(email, pwd);
		assertFalse(loginResult);
	}

}
