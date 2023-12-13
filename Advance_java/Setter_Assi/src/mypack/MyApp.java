package mypack;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext=new ClassPathXmlApplicationContext("account.xml");
        Soldier s=(Soldier)appContext.getBean("soldier");
        s.perform();
	}
}
