package com.evergreen.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;

import com.evergreen.dao.BookDAO;
import com.evergreen.dao.CategoryDAO;
import com.evergreen.entities.Book;
import com.evergreen.entities.Category;
import com.evergreen.utilities.HibernateHelper;

public class Book_Service {
	Session session;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private BookDAO bookDAO;
	private CategoryDAO categoryDAO;

	public Book_Service(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		session = HibernateHelper.getSessionFactory().openSession();
		bookDAO = new BookDAO(session);
		categoryDAO = new CategoryDAO(session);
	}

	public void listBook() throws ServletException, IOException {
		listBook(null);
	}

	public void listBook(String message) throws ServletException, IOException {
		List<Book> list = bookDAO.listAll();
		request.setAttribute("listBook", list);
		if (message != null) {
			request.setAttribute("message", message);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("book_list.jsp");
		dispatcher.forward(request, response);
	}

	public void showCategoryForBook() throws ServletException, IOException {
		List<Category> list = categoryDAO.listAll();
		request.setAttribute("listCategory", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book_form.jsp");
		dispatcher.forward(request, response);
	}

	public void createBook() throws ServletException, IOException, ParseException {
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");

		// Check for unique title
		Book existBook = bookDAO.findByTitle(title);
		if (existBook != null) {
			String message = " Book by same Title already exist ";
			request.setAttribute("message", message);
			listBook();
			return;
		} else {
			String author = request.getParameter("author");
			String isbn = request.getParameter("isbn");
			String description = request.getParameter("description");
			float price = Float.parseFloat(request.getParameter("price"));
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date publishDate = dateFormat.parse(request.getParameter("publishDate"));

			Book book = new Book();
			book.setTitle(title);
			book.setAuthor(author);
			book.setDescription(description);
			book.setIsbn(isbn);
			book.setPublishDate(publishDate);
			book.setPrice(price);
			Category category2 = categoryDAO.get(categoryId);
			book.setCategory(category2);

			Part part = request.getPart("image");
			if (part != null && part.getSize() > 0) {
				long size = part.getSize();
				byte[] imageBytes = new byte[(int) size];
				InputStream inputStream = part.getInputStream();
				inputStream.read(imageBytes);
				inputStream.close();
				book.setImage(imageBytes);
			}

			Book createdBook = bookDAO.create(book);
			if (createdBook.getBookId() > 0) {
				String message = " Book created ";
				request.setAttribute("message", message);
				listBook();
			}
		}
	}

	public void listBooksByCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		List<Book> listBooks = bookDAO.listByCategory(categoryId);
		request.setAttribute("listBooks", listBooks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("frontend/book_list_by_category.jsp");
		dispatcher.forward(request, response);
	}
}
















