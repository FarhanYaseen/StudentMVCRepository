package Controller;

import Model.*;

public class StudentController {

	
	StudentDBHandler db;
	public StudentController()
	{
		db= new StudentDBHandler();
		/*db.openConnection();
		db.createStudentTable();
		db.closeConnection();*/
		
	}
	public boolean addStudent(Student student)
	{
		boolean flag;
		db.openConnection();
		flag=db.addStudent(student);
		db.closeConnection();
		return flag;
	}
	public boolean deleteStudent(int id)
	{
		return db.deleteStudent(id);
	}
	
	
}
