

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.Student;
import dao.StudentDAO;
import dao.StudentDAODataImpl;
import dao.StudentDAOFileImpl;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDAO sdao;
		Student s=new Student();
		s.setName(request.getParameter("studentName"));
		s.setAddress(request.getParameter("studentAddress"));
		String d= request.getParameter("persistenceStore");
		if(d.equals("File")) {
			sdao=new StudentDAOFileImpl();
			s.setRoll(5);
		}
		else {
			sdao=new StudentDAODataImpl();
		}
		sdao.addStudent(s);
		response.getWriter().println("Student added successfully!");
		
	}
	

}
