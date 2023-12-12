package myprop;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class assi3 {
public static void main(String[] args) {
	String ss="jdbc:mysql://localhost:3306/bit";
	System.out.println("Enter rollno");
	Scanner sc =  new Scanner(System.in);
	int roll=sc.nextInt();
	System.out.println("Enter name");
	String nm=sc.next();
	System.out.println("Enter age");
	int ag=sc.nextInt();
	try(Connection conn = DriverManager.getConnection(ss,"root","root")) {
		PreparedStatement pst = conn.prepareStatement("insert into student values(?,?,?)");
		pst.setInt(1, roll);
		pst.setString(2, nm);
		pst.setInt(3, ag);
		pst.execute();
		java.sql.Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from student");
		while(rs.next()) {
			System.out.println("Roll NO: "+rs.getInt(1)+" Name "+rs.getString(2)+" Age "+rs.getInt(3));
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}