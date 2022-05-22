
package uts.isd.model.dao;

import java.sql.Connection;

/** 
* Super class of DAO classes that stores the database information 
*  
*/
public abstract class DB {
   protected String URL = "jdbc:derby://localhost:1527/";
   protected String db = "usersdb";
   protected String dbuser = "isduser";
   protected String dbpass = "isduser";
   protected String driver = "org.apache.derby.jdbc.ClientDriver";
   protected Connection conn; 
}
