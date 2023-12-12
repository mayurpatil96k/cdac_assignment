package myprop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class assi2 {
	public static void main(String[] args) {
		String ss="jdbc:mysql://localhost:3306/bit";
		System.out.println("Enter Designation To get employee");
		Scanner sc =  new Scanner(System.in);
		String de=sc.nextLine();
		try(Connection conn = DriverManager.getConnection(ss,"root","root")) {
			PreparedStatement pst = conn.prepareStatement("select * from employee where desig=?");
			pst.setString(1, de);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
