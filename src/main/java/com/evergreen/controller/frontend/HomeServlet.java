package com.evergreen.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evergreen.dao.CategoryDAO;
import com.evergreen.entities.Category;

@WebServlet("")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO dao;
	
    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao = new CategoryDAO(session);
		List<Category> list = dao.listAll();
		request.setAttribute("listCategory", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("frontend/index.jsp");
		dispatcher.forward(request, response);
	}

}