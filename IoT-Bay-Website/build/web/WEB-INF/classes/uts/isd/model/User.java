package uts.isd.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;


public class User implements Serializable {

	private int user_id;
	private String name;
	private String date_of_birth;
	private String phone_number;
	private String address;
	private String email;
	private String password;
	private String is_staff;

        public User(int user_id, String name, String date_of_birth, String phone_number, String address, String email, String password, String is_staff) {
            this.user_id = user_id;
            this.name = name;
            this.date_of_birth = date_of_birth;
            this.phone_number = phone_number;
            this.address = address;
            this.email = email;
            this.password = password;
            this.is_staff = is_staff;
        }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIs_staff() {
		return is_staff;
	}

	public void setIs_staff(String is_staff) {
		this.is_staff = is_staff;
	}

}
