package com.evergreen.dao;

import java.util.List;
import com.evergreen.entities.Tbl_UserDetail;

public interface GenericDao<T> {
	public T create(T t);
	public T update(T t);
	public T get(Object id);
	public void delete(Object id);
	public List<T> listAll();
	public long count();
	public Tbl_UserDetail findByEmail(String email);
	
	// Category
	//public CategoryDAO findByCategory(String name);
}
