package com.evergreen.controller.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evergreen.service.Category_Service;

@WebServlet("/admin/create_category")
public class CreateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateCategory() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category_Service service = new Category_Service(request, response);
		service.createCategory();
	}

}
