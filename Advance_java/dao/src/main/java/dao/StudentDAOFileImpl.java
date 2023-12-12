package dao;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class StudentDAOFileImpl implements StudentDAO {

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		try
		{
			FileOutputStream fos=new FileOutputStream("d:\\trial.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(student);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
	}

}
