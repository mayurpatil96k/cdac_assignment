

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class StudentServ
 */
public class StudentServ extends HttpServlet {
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
		String a=request.getParameter("name");
		String b=request.getParameter("address");
		String c=request.getParameter("rollNo");
		String d=request.getParameter("age");
		ArrayList<Integer> arr= new ArrayList<>();
		try {
			PreparedStatement pst=con.prepareStatement("Insert into student values(?,?,?,?)");
			PreparedStatement pst1=con.prepareStatement("select rollno from student");
			pst.setInt(1,Integer.parseInt(c.trim()));
			pst.setString(2, a);
			pst.setString(3, d);
			pst.setInt(4,Integer.parseInt(d.trim()));
			pst.execute();
			ResultSet rs=pst1.executeQuery();
			while(rs.next()) {
				arr.add(rs.getInt(1));
			}
			request.setAttribute("arr", arr);
			RequestDispatcher rd=request.getRequestDispatcher("Report.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
