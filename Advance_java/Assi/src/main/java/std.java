

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class std
 */
public class std extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		String ss="jdbc:mysql://localhost:3306/bit";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(ss,"root","root");
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw= response.getWriter();
		try {
			PreparedStatement pst = con.prepareStatement("select * from student");
			ResultSet rs=pst.executeQuery();
			pw.println("+-----------+---------+-----------+--------------+\n");
			pw.println("| Roll No   | Name    | Age       | Address      |\n");
			pw.println("+-----------+---------+-----------+--------------+\n");
			while(rs.next()) {
				int a=rs.getInt(1);
				String b=rs.getString(2);
				String c=rs.getString(4);
				int d=rs.getInt(3);
				pw.println("|   " + String.format("%-6d", a) + "    | " + String.format("%-8s", b) + " | " + String.format("%-6d", d) + "    | " + String.format("%-12s", c) + " |");
				pw.println("+-----------+---------+-----------+--------------+\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw= response.getWriter();
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age").trim());
		String address=request.getParameter("address");
		try {
			
			PreparedStatement pst=con.prepareStatement("Insert into student(name,age,address)values(?,?,?)");
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setString(3, address);
			int k=pst.executeUpdate();
			if(k>0)
			{
				pw.println("Student has been added");
				
			}
			else
			{
				pw.println("cannot add");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
