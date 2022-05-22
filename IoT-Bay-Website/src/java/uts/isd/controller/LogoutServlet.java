
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

public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		DBManager db = (DBManager) session.getAttribute("manager");
		AccessLog accessLog = (AccessLog)session.getAttribute("log" );
		accessLog.setLogout_time(Utils.getDateTime());
            try {
                db.updateLog(accessLog);
            } catch (SQLException ex) {
                Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
		session.invalidate();
		request.getRequestDispatcher("logout.jsp").include(request, response);
	}
}
