package mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class Main 
{
	public static void main(String[] args) 
	{
		SessionFactory factory=MyConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
        Employee e1=new Employee();
        e1.setName("abc");
        e1.setDesig("officer");
        e1.setSalary(30000);
            
        Employee e2=new Employee();       
        e2.setName("xyz");
        e2.setDesig("manager");
        e2.setSalary(40000);
        session.persist(e1);
        session.persist(e2);
        tr.commit(); 
        factory.close();
        System.out.println("done with employees");  
	}
}
