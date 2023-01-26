package com.evergreen.dao;

import java.util.List;

import org.hibernate.Session;
import com.evergreen.entities.Book;
import com.evergreen.entities.Tbl_UserDetail;

public class BookDAO extends JpaDao<Book> implements GenericDao<Book> {
	protected Session session;
	
	public BookDAO(Session session) {
		super(session);
		this.session = session;
	}
	
	@Override
	public Book create(Book book) {
		return super.create(book);
	}

	@Override
	public Book get(Object id) {
		return null;
	}

	@Override
	public void delete(Object id) {
		
	}

	@Override
	public List<Book> listAll() {
		return super.findWithNamedQuery("Book.findAll");
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public Tbl_UserDetail findByEmail(String email) {
		return null;
	}
	
	public Book findByTitle(String title) {
		List<Book> listBook = super.findWithNamedQuery("Book.findByTitle", "title", title);
		if (listBook != null && listBook.size() > 0) {
			return listBook.get(0);
		}
		return null;
	}
	
	public List<Book> listByCategory(int categoryId) {
		return super.findWithNamedQuery("Book.findBycategory", "catId", categoryId);
	}
}
