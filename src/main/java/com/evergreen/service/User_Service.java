package com.evergreen.service;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

import com.evergreen.dao.*;
import com.evergreen.utilities.*;
import com.evergreen.dao.UserDao;
import com.evergreen.entities.Tbl_UserDetail;
import com.evergreen.utilities.*;
import com.evergreen.service.*;

public class User_Service {
	Session session;
	private UserDao userDao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public User_Service(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		session = HibernateHelper.getSessionFactory().openSession();
		userDao = new UserDao(session);
	}

	public void createUser() throws ServletException, IOException {
		session = HibernateHelper.getSessionFactory().openSession();
		userDao = new UserDao(session);
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String pwd = request.getParameter("password");
		Tbl_UserDetail existUser = userDao.findByEmail(email);
		if (existUser != null) {
			String message = "User exist with: " + email;
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else {
			Tbl_UserDetail newUser = new Tbl_UserDetail(email, fullname, pwd);
			userDao.create(newUser);
			listUser("New User created Successfully");
		}
	}

	public void listUser() throws ServletException, IOException {
		listUser(null);
	}

	public void listUser(String message) throws ServletException, IOException {
		List<Tbl_UserDetail> listUser = userDao.listAll();
		request.setAttribute("listUser", listUser);
		if (message != null) {
			request.setAttribute("message", message);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_list.jsp");
		dispatcher.forward(request, response);
	}

	public void editUser() throws ServletException, IOException {
		session = HibernateHelper.getSessionFactory().openSession();
		userDao = new UserDao(session);
		int userId = Integer.parseInt(request.getParameter("id"));
		Tbl_UserDetail user = userDao.get(userId);
		// System.out.print(user.getFullname());
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_form.jsp");
		dispatcher.forward(request, response);
	}

	public void updateUser() throws ServletException, IOException {
		session = HibernateHelper.getSessionFactory().openSession();
		userDao = new UserDao(session);
		int userId = Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String pwd = request.getParameter("password");
		// System.out.print(userId + "" + email + " " + fullname + " " + pwd);

		Tbl_UserDetail existUser = userDao.findByEmail(email);
		if (existUser != null) {
			String message = "User cannot be updated";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else {
			Tbl_UserDetail newUser = new Tbl_UserDetail(userId, email, fullname, pwd);
			userDao.update(newUser);
			listUser("User modified Successfully");
		}
	}

	public void deleteUser() throws ServletException, IOException {
		session = HibernateHelper.getSessionFactory().openSession();
		userDao = new UserDao(session);
		int userId = Integer.parseInt(request.getParameter("id"));
		userDao.delete(userId);
		listUser("User deleted Successfully");
	}

	public void login() throws ServletException, IOException {
		session = HibernateHelper.getSessionFactory().openSession();
		userDao = new UserDao(session);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean loginResult = userDao.checkLogin(email, password);
		if (loginResult) {
			System.out.println("Login");
			request.getSession().setAttribute("useremail", email);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
			dispatcher.forward(request, response);
		} else {
			String message = "Login failed";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
