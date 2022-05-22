
package uts.isd.controller;

import java.io.IOException;

import java.sql.SQLException;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import uts.isd.model.AccessLog;
import uts.isd.model.User;
import uts.isd.model.Utils;
import uts.isd.model.dao.DBManager;


public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user1 = (User)session.getAttribute("user");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone_number = request.getParameter("phone_number");
		String date_of_birth = request.getParameter("date_of_birth");
		String address = request.getParameter("address");
		
		DBManager db = (DBManager) session.getAttribute("manager");
		User user = new User();
		user.setPassword(password);
		user.setName(name);
		user.setPhone_number(phone_number);
		user.setDate_of_birth(date_of_birth);
		user.setAddress(address);
		user.setUser_id(user1.getUser_id());
		
            try {
                db.updateUser(user);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
		user.setUser_id(user1.getUser_id());
		user.setIs_staff(user1.getIs_staff());
		user.setEmail(user1.getEmail());
		
		session.setAttribute("user",user);
		
		request.getRequestDispatcher("mainpage.jsp").include(request, response);

	}
}
