package uts.isd.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import uts.isd.model.AccessLog;
import uts.isd.model.User;

public class DBManager {
    private Statement st;
    public DBManager(Connection conn) throws SQLException {       
        st = conn.createStatement();   
    }

    public User selseByEmailAndPwd(String email, String pwd) throws SQLException {
		String sql = "select * from isduser.iot_bay_user where email ='" + email + "' and password = '" + pwd + "'";
		ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
                            String uemail= rs.getString(6);
                            String upwd = rs.getString(7);
                            if(uemail.equals(email) && upwd.equals(pwd)){
                                int uid = rs.getInt(1);
				String uname = rs.getString(2);
                                String udob = rs.getString(3);
                                String phonenum = rs.getString(4);
                                String uadd = rs.getString(5);
                                String staff = rs.getString(8);
                                return new User(uid,uname,udob,phonenum,uadd,uemail,upwd,staff);
                      
                            }
			}
                return null;

        }
        

	public int selseMaxId(String sql) throws SQLException {
		int maxId = 0;
                ResultSet rs = st.executeQuery(sql);
                maxId = rs.getInt("id");
		return maxId + 1;

	}

	public void updateUser(User user) throws SQLException {
		st.executeUpdate( "update isduser.iot_bay_user set name ='" + user.getName() + "', date_of_birth = '"+ user.getDate_of_birth() 
                        + "' ," + " phone_number = '" + user.getPhone_number() + "' , address = '"+ user.getAddress() 
                        + "', password = '" + user.getPassword() + "' where user_id =" + user.getUser_id());
	}

	public void delUser(User user) throws SQLException {
		st.executeUpdate( "delete from isduser.iot_bay_user where user_id =" + user.getUser_id());

	}

	public void insertUser(User user) throws SQLException {
                user.setUser_id(selseMaxId("select max(user_id) as id from iot_bay_user "));
		st.executeUpdate( "INSERT INTO isduser.iot_bay_user " + "VALUES ('" + user.getUser_id() + "', '" + user.getName() + "', '" + user.getDate_of_birth() + "', '"
				+ user.getPhone_number() + "', '" + user.getAddress() + "', '" + user.getEmail() + "', '"
				+ user.getPassword() + "', '1')");

	}

	public void insertLog(AccessLog accessLog) throws SQLException{

		accessLog.setId(selseMaxId("select max(id) as id from access_log "));
                st.executeUpdate( "INSERT INTO isduser.access_log " + "VALUES (" + accessLog.getId() + ", '"
				+ accessLog.getUser_id() + "', '" + accessLog.getLogin_time() + "');");

	}

	public void updateLog(AccessLog accessLog) throws SQLException{
		st.executeUpdate("update isduser.access_log set logout_time = '" + accessLog.getLogout_time() + "' where id="
				+ accessLog.getId());

	}
	
	public List<AccessLog> selseByUserId(int userId) throws SQLException{
		String sql = "select * from access_log where user_id ='" + userId + "'";
		ResultSet rs = st.executeQuery(sql);
		List<AccessLog> list = new ArrayList<AccessLog>();
		AccessLog log = null;
			while (rs.next()) {
				log = new AccessLog();
				log.setId(rs.getInt("id"));
				log.setUser_id(rs.getInt("user_id"));
				log.setLogin_time(rs.getString("login_time"));
				log.setLogout_time(rs.getString("logout_time"));
				list.add(log);
                        }
                        return list;
	}
    }
