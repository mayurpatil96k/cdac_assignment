

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
import java.sql.SQLException;

/**
 * Servlet implementation class RegisterServ
 */
public class RegisterServ extends HttpServlet {
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

	private static final long serialVersionUID = 1L;
	private Connection con;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String a=(String) request.getParameter("name");
		String b=(String) request.getParameter("address");
		String c=(String) request.getParameter("email");
		String d=(String) request.getParameter("login");
		String e=(String) request.getParameter("password");
		Boolean q;
		PrintWriter pw=resp.getWriter();
		
		try {
			
			PreparedStatement pst=con.prepareStatement("insert into register(name,address,email,login,pass)values(?,?,?,?,?)");
			pst.setString(1, a);
			pst.setString(2, b);
			pst.setString(3, c);
			pst.setString(4, d);
			pst.setString(5, e);
			q=pst.execute();
			if(q) {
				pw.println("Data Not Inserted");
			}
			else {
				pw.println("Data Inserted");
			}
			
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
	}
	


}
