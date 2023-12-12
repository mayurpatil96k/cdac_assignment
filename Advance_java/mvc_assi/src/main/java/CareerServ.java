

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc_assi.CareerExpert;

import java.io.IOException;

/**
 * Servlet implementation class CareerServ
 */
public class CareerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		String a=request.getParameter("EQ");
		CareerExpert ce= new CareerExpert();
		String b=ce.getAdvice(a);
		System.out.println(b);
		request.setAttribute("adv", b);
		RequestDispatcher rd=request.getRequestDispatcher("CareerDetails.jsp");
		rd.forward(request, responce);
	}

}
