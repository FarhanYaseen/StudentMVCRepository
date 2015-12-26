package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDBHandler {

	Connection connection;
	Statement statement;

	public StudentDBHandler() {

	}

	public void openConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = null;
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public boolean createStudentTable() {
		try {
			// statement.setQueryTimeout(30); // set timeout to 30 sec.
			statement.executeUpdate("drop table if exists student");
			statement.executeUpdate("create table student (id integer, name string)");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean addStudent(Student student) {

		try {
			statement.executeUpdate("insert into student values" + "("
					+ student.getId() + ",'" + student.getName() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteStudent(int id) {

		return false;
	}

	public boolean updateStudent(Student student) {

		return false;
	}

	public ArrayList<Student> GetAllStudents() {

		ArrayList<Student> list = new ArrayList<Student>();
		ResultSet rs;
		try {
			rs = statement.executeQuery("select * from student");
			while (rs.next()) {
				Student student = new Student();

				String name = rs.getString("name");
				int id = rs.getInt("id");

				student.setId(id);
				student.setName(name);	
				list.add(student);
				
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Student GetStudent(int studentid) {

		Student student = new Student();
		ResultSet rs;
		try {
			rs = statement.executeQuery("select * from student where id="+studentid+";" );
			while (rs.next()) {

				String name = rs.getString("name");
				int id = rs.getInt("id");
				student.setId(id);
				student.setName(name);		
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return student;
	}

}
