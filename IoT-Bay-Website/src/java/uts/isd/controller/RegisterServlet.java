
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

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Validator validator = new Validator();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone_number = request.getParameter("phone_number");
		String date_of_birth = request.getParameter("date_of_birth");
		String address = request.getParameter("address");
		String tos = request.getParameter("tos");

		if (tos == null) {
			request.setAttribute("otherErr", "Please accept the tos to complete the register");
			request.getRequestDispatcher("CustomerRegister.jsp").include(request, response);
		}

	  if (!validator.validateEmail(email)) {
			session.setAttribute("emailErr", "Error: Email Format Incorrect");
			request.getRequestDispatcher("CustomerRegister.jsp").include(request, response);
		}  else {
		DBManager db = (DBManager) session.getAttribute("manager");
				User user = null;
                    try {
                        user = db.selseByEmailAndPwd(email, null);
                    } catch (SQLException ex) {
                        Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

				if (user != null) {
					session.setAttribute("otherErr", "Account already exsist");
					request.getRequestDispatcher("CustomerRegister.jsp").include(request, response);
				} else {
					user = new User();
					user.setEmail(email);
					user.setPassword(password);
					user.setName(name);
					user.setPhone_number(phone_number);
					user.setDate_of_birth(date_of_birth);
					user.setAddress(address);
                                    try {
                                        db.insertUser(user);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                                    }
					session.setAttribute("user", user);
					
					
					AccessLog accessLog = new AccessLog();
					accessLog.setUser_id(user.getUser_id());
					accessLog.setLogin_time(Utils.getDateTime());
                                    try {
                                        db.insertLog(accessLog);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                                    }
					session.setAttribute("log", accessLog);

					
					request.getRequestDispatcher("mainpage.jsp").include(request, response);
				}
		}
	}
}
