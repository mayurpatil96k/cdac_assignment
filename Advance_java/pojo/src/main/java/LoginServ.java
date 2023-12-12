

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServ
 */
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String d=(String) request.getParameter("login");
		String e=(String) request.getParameter("password");
		PrintWriter pw=response.getWriter();
		
		try {
			
			PreparedStatement pst=con.prepareStatement("select * from register where login=? and pass=?");
			pst.setString(1, d);
			pst.setString(2, e);
			ResultSet rs = pst.executeQuery(); // Use executeQuery for SELECT queries
			if (rs.next()) {
				RequestDispatcher rd=request.getRequestDispatcher("success.html");
				rd.forward(request,response);
			}
			else {
				pw.println("ERROR>>>>>>>???????");
			}
			
			
			
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
	}

}
