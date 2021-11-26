package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {

	public int insertUser(UserBean userBean) {
		Connection con = DbConnection.getConnection();

		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into users (firstName,email,password) values (?,?,?)");
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getEmail());
			pstmt.setString(3, userBean.getPassword());

			// run query

			// executeUpdate() -> insert update delete
			// executeQuery() -> select

			int i = pstmt.executeUpdate();// query -> db -> run
			if (i == 0) {
				System.out.println("record not inserted....");
				return 0;
			} else {
				System.out.println("record inserted....");
				return 1;
			}

		} catch (Exception e) {
			// sendMailTodev(e,email);

			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;

	}

	public ArrayList<UserBean> listUsers() {
		// open connection

		ArrayList<UserBean> users = new ArrayList<UserBean>();// 10 -> 50%
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from users");) {

			// select * from users
			ResultSet rs = pstmt.executeQuery();
			// all data send to jsp
			String fn, em, pwd;
			int userId;

			// 10
			while (rs.next()) {
				UserBean user = new UserBean(); // ***

				user.setUserId(rs.getInt("userId"));
				user.setFirstName(rs.getString("firstName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

				users.add(user);
			}

			// jump to jsp
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;

	}
}
