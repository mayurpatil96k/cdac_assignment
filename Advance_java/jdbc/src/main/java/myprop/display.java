package myprop;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class display {
public static void main(String[] args) {
	Product p = new Product(1,50,80.69,"Toothpaste");
	System.out.println(p.toString());
	String ss="jdbc:mysql://localhost:3306/bit";
	try(Connection con=DriverManager.getConnection(ss,"root","root")) {
		PreparedStatement pst = con.prepareStatement("insert into product(qty,cost,pname) values (?,?,?)");
		pst.setInt(1, p.getQty());
		pst.setDouble(2, p.getCost());
		pst.setString(3, p.getPname());
		pst.execute();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	p=null;
	Product p1 = null;
	try(Connection con=DriverManager.getConnection(ss,"root","root")) {
		java.sql.Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from product");
		rs.next();
		int no = rs.getInt(1);
		int no1=rs.getInt(2);
		double pri=rs.getDouble(3);
		String s=rs.getString(4);
		p1=new Product(no, no1, pri, s);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(p1);
}
}
