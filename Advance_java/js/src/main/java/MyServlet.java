

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import javax.management.MBeanRegistration;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> myarr=new ArrayList<>();
		myarr.add("Mayur");
		myarr.add("Ritik");
		myarr.add("Tripti");
		myarr.add("Shalinni");
		myarr.add("Karan");
		myarr.add("Sanjay");
		myarr.add("Aditya");
		myarr.add("Sushil");
		HttpSession session= request.getSession();
		session.setAttribute("arr", myarr);
		response.sendRedirect("MyJsp.jsp");
	}

}
