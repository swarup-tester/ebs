package com.evergreen.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.evergreen.entities.Category;
import com.evergreen.entities.Tbl_UserDetail;

public class CategoryDAO extends JpaDao<Category> implements GenericDao<Category> {
	protected Session session;

	public CategoryDAO(Session session) {
		super(session);
		this.session = session;
	}

	public Category create(Category category) {
		return super.create(category);
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public Category update(Category category) {
		return super.update(category);
	}

	@Override
	public Category get(Object id) {
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Category.class, id); 
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Category findByCategory(String name) {
		List<Category> listCategory = super.findWithNamedQuery("Category.findByCategory", "name", name);
		if (listCategory != null && listCategory.size() > 0) {
			return listCategory.get(0);
		}
		return null;
	}

	@Override
	public Tbl_UserDetail findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
