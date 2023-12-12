

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypack.SingletonCon;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Servlet implementation class firstserv
 */
public class firstserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
		con=SingletonCon.getCon();
		}
	catch(Exception e) {
		System.out.println(e);
	}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
		    pw.println("Using properties");
		        pw.println("<br>");
			java.sql.Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from dept");
			while(rs.next())
			{
				pw.println(rs.getInt(1));
				pw.println(rs.getString(2));
				pw.println(rs.getString(3));
				pw.println();
	
			}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	
	}

}
