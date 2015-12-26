package View;

import javax.swing.JOptionPane;

import Controller.StudentController;
import Model.Student;

public class StudentView {
	public static void main(String args[])
	{
		StudentController cnt= new StudentController();
		String name=JOptionPane.showInputDialog(null,"Enter Name");
		String id=JOptionPane.showInputDialog(null,"Enter id");
		Student student= new Student();
		student.setName(name);
		student.setId(Integer.parseInt(id));
		boolean flag=cnt.addStudent(student);
		if(flag)
		{
			JOptionPane.showMessageDialog(null, "Student added successfully");
		}
		else
		{
			
			JOptionPane.showMessageDialog(null, "Student not added successfully");
		}
	}

}
