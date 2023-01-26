package com.evergreen.service;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

import com.evergreen.dao.CategoryDAO;
import com.evergreen.entities.Category;
import com.evergreen.utilities.HibernateHelper;

public class Category_Service {
	Session session;
	private CategoryDAO dao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public Category_Service(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		session = HibernateHelper.getSessionFactory().openSession();
		dao = new CategoryDAO(session);
	}

	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}

	public void listCategory(String message) throws ServletException, IOException {
		List<Category> list = dao.listAll();
		request.setAttribute("listCategory", list);
		if (message != null) {
			request.setAttribute("message", message);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("category_list.jsp");
		dispatcher.forward(request, response);
	}

	public void createCategory() throws ServletException, IOException {
		String name = request.getParameter("name");
		Category exist = dao.findByCategory(name);
		if (exist != null) {
			String message = "Category exist with: " + name;
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else {
			Category category = new Category(name);
			dao.create(category);
			listCategory("New category Created");
		}
	}

	public void editCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		Category category = dao.get(categoryId);
		System.out.print("Category to be Edited: " + category.getName());
		request.setAttribute("category", category);
		RequestDispatcher dispatcher = request.getRequestDispatcher("category_form.jsp");
		dispatcher.forward(request, response);
	}

	public void updateCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		// Accept User input from the HTML form
		String name = request.getParameter("name");
		//System.out.println("Selected Category: "+name);
		Category existCategory = dao.findByCategory(name);
		// If the Newly Edited Category name match with existing category, then if gets executed
		if (existCategory != null) {
			String message = "Category cannot be updated";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}else {
			Category editCategory = new Category(categoryId, name);
			dao.update(editCategory);
			listCategory("Category modified Successfully");
		}

	}

	public void deleteCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		dao.delete(categoryId);
		listCategory("Category deleted Successfully");
	}
}
