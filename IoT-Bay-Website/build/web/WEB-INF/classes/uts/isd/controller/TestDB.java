/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import uts.isd.model.User;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author billfan
 */


public class TestDB {

private static Scanner in = new Scanner(System.in);

 

public static void main(String[] args) throws SQLException {

try {

DBConnector connector = new DBConnector();

Connection conn = connector.openConnection();

DBManager db = new DBManager(conn);

 

System.out.print("User email: ");

String email = in.nextLine();

System.out.print("User name: ");

String name = in.nextLine();

System.out.print("User password: ");

String password = in.nextLine();

System.out.print("User gender: ");

String gender = in.nextLine();

System.out.print("User favorite color: ");

String favcol = in.nextLine();
User user = new User(1,email,name,password,gender,"1","1","1");
db.insertUser(user);

System.out.println("User is added to the database.");

connector.closeConnection();

 

} catch (ClassNotFoundException | SQLException ex) {

Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);

}

}

}

