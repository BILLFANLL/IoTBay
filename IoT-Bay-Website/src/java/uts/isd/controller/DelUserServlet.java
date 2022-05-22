package uts.isd.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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


public class DelUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user1 = (User)session.getAttribute("user");

		DBManager db = (DBManager) session.getAttribute("manager");
		User user = new User();
		user.setUser_id(user1.getUser_id());
            try {
                db.delUser(user);
            } catch (SQLException ex) {
                Logger.getLogger(DelUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
		 
		session.invalidate();

		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	
}
