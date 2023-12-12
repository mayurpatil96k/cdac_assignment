package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDAODataImpl implements StudentDAO {

	private SessionFactory sf;
	private Session session;
	
	public StudentDAODataImpl()
	{
		Configuration cfg=new Configuration();		
		cfg.configure("hibernate.cfg.xml");
		sf=cfg.buildSessionFactory();
	}
	
	@Override
	public void addStudent(Student student) {
		session=sf.openSession();
		Transaction transaction = session.beginTransaction();
		   session.persist(student);
		   transaction.commit();
		   session.close();
		   System.out.println("Done with commit");
	}

}
