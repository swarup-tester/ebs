package com.evergreen.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.evergreen.utilities.HibernateHelper;
import com.evergreen.entities.Category;

public class CategoryDaoTest {

	private static CategoryDAO dao;
	private static Session session;
	private static Transaction tx;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		session = HibernateHelper.getSessionFactory().openSession();
		tx = session.beginTransaction();
		dao = new CategoryDAO(session);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tx.commit();
		session.close();
	}
	
	@Test
	public void testCreateCategory() {
		Category category = new Category();
		category.setName("Frontend");
		Category result = dao.create(category);
		assertTrue(result != null && result.getCategoryId()>0);
	}
	
	@Test
	public void testListAll() {
		List<Category> categories = dao.listAll();
		for(Category category: categories) {
			System.out.println(category.getName());
		}
		assertTrue(categories.size() > 0);
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
