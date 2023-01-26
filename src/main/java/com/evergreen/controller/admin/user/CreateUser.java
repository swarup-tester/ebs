package com.evergreen.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evergreen.service.User_Service;

@WebServlet("/admin/create_user")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateUser() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	super.service(req, resp);
    }
    
    @Override
    public void destroy() {
    	super.destroy();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User_Service user_Service = new User_Service(request, response);
		user_Service.createUser();
		//response.getWriter().print("Email: "+email);
	}

}
