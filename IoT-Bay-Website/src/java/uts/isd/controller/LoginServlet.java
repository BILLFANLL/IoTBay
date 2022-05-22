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


public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                HttpSession session = request.getSession();
		DBManager db = (DBManager) session.getAttribute("manager");
		
		Validator validator = new Validator();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = null;
		validator.clear(session);

		if (!validator.validateEmail(email)) {
			session.setAttribute("emailErr", "Error: Email Format Incorrect");
			request.getRequestDispatcher("login.jsp").include(request, response);
		} else {
                    try {
                        user = db.selseByEmailAndPwd(email, password);
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
			if (user != null) {
				session.setAttribute("user", user);
				AccessLog accessLog = new AccessLog();
				accessLog.setUser_id(user.getUser_id());
				accessLog.setLogin_time(Utils.getDateTime());
                        try {
                            db.insertLog(accessLog);
                        } catch (SQLException ex) {
                            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
				session.setAttribute("log", accessLog);
				request.getRequestDispatcher("mainpage.jsp").include(request, response);
			} else {
				session.setAttribute("existErr", "Invalid email or password.");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
		}

	}
}