package com.evergreen.controller.frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evergreen.service.Book_Service;

@WebServlet("/view_category")
public class ViewBookByCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewBookByCategoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book_Service service = new Book_Service(request, response);
		service.listBooksByCategory();
	}

}
