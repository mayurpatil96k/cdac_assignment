package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;

/**
 * Servlet implementation class RegisterServ
 */
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory= cfg.buildSessionFactory();
		Session session=factory.openSession();
		org.hibernate.Transaction tr= session.beginTransaction();
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		login l=new login();
		l.setAddress(address);
		l.setName(name);
		l.setEmail(email);
		l.setLogin(login);
		l.setPassword(password);
		session.persist(l);
		tr.commit();
		session.close();
		pw.println("Done with book");
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
