

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
 * Servlet implementation class ViewServ
 */
public class ViewServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		
		try {
			java.sql.Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from register");
			while(rs.next()) {
				String a=rs.getString(2);
				String b=rs.getString(3);
				String c=rs.getString(4);
				String d=rs.getString(5);
				pw.println(a+" "+b+" "+c+" "+d+"<br>");
			}
			
			
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ss="jdbc:mysql://localhost:3306/bit";
		try {
			 con=DriverManager.getConnection(ss,"root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
