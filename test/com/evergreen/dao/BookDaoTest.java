package com.evergreen.dao;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.evergreen.entities.Book;
import com.evergreen.entities.Category;
import com.evergreen.utilities.HibernateHelper;

public class BookDaoTest {
	private static Session session;
	private static Transaction tx;
	private static BookDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		session = HibernateHelper.getSessionFactory().openSession();
		tx = session.beginTransaction();
		dao = new BookDAO(session);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tx.commit();
		session.close();
	}

	@Test
	public void testCreateBook() throws ParseException, IOException {
		Book newBook = new Book();
		Category category = new Category("DBMS");
		category.setCategoryId(2);
		newBook.setCategory(category);
		newBook.setTitle("Moderate DBMS");
		newBook.setAuthor("Mathew");
		newBook.setDescription("For Intermediate");
		newBook.setPrice(588);
		newBook.setIsbn("12345");

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("05/18/2020");
		newBook.setPublishDate(publishDate);

		//String imagePath = "C:\\Users\\Swarup-PC\\Desktop\\books\\Core Java.jpg";
		File fi = new File("C:\\Users\\Swarup-PC\\Desktop\\books\\Core Java 2.jpg");
//		byte[] imageByte = Files.readAllBytes(Paths.get(imagePath));
		byte[] imageByte = Files.readAllBytes(fi.toPath());
		newBook.setImage(imageByte);
		
		Book createBook = dao.create(newBook);
		assertTrue(createBook != null && createBook.getBookId() > 0);
	}
	
	@Test
	public void testListByCategory() {
		int categoryId = 2;
		List<Book> listBooks = dao.listByCategory(categoryId);
		System.out.println(listBooks.size());
		assertTrue(listBooks.size()>0);
	}

}
