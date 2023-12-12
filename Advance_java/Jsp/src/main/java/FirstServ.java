

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class FirstServ
 */
public class FirstServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServ() {
        super();
        // TODO Auto-generated constructor stub
    }

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			java.sql.Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select pname from product");
			ArrayList<String> arr=new ArrayList<>();
			while(rs.next()) {
				arr.add(rs.getString(1));
			}
			request.setAttribute("arr", arr);
			RequestDispatcher rd=request.getRequestDispatcher("Shop.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
