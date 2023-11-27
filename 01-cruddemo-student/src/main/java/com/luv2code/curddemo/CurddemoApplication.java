package com.luv2code.curddemo;

import com.luv2code.curddemo.dao.StudentDAO;
import com.luv2code.curddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CurddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}


	// commandLineRUnner is from spring boot framework and is executed after spring beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO)
	{
		return runner -> {
			//create single student
			//createStudent(studentDAO);

			//create multiple students
			createMultipleStudents(studentDAO);

			//reading student data from database
			//readStudent(studentDAO);


			//it is to retrieve data from table
			//queryForStudents(studentDAO);

			//retrieve data based on lastName by passing the lastName to function as parameter
			//queryForStudentsByLastName(studentDAO);

			// updating the student details
			//updateStudent(studentDAO);

			// deleting the student with a certain id : primary key
			//deleteStudent(studentDAO);

			//deleting all students from the database
			//deleteAllStudents(studentDAO);
		};
	}


	public void deleteAllStudents(StudentDAO studentDAO)
	{
		System.out.println("Deleting all students");
		int numOfRowsDeleted = studentDAO.deleteAll();

		System.out.println("Number of Rows Deleted : "+numOfRowsDeleted);
	}
	private void deleteStudent(StudentDAO studentDAO)
	{
		int studentId = 3;
		System.out.println("Deleting student id: "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO)
	{
		// retrive student based on the id: primary key
		int studentID = 1;
		System.out.println("Getting student with Id: "+studentID);
		Student myStudent = studentDAO.findById(studentID);

		// change first name to "podduturi"
		System.out.println("Updating student");
		myStudent.setFirstName("Rohith");

		// update the student in database
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated Student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Rao");

		//	display the list of students
		for(Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}
	}

	public void queryForStudents(StudentDAO studentDAO)
	{
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("creating new student");
		Student tempStudent = new Student("Prathihas","Reddy","Prathihas@gmail.com");

		// save the student in database
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theID = tempStudent.getId();
		System.out.println("saed student: Generated ID: "+ theID);

		// retrieve the student based on the ID: primary key
		System.out.println("Retrieving the stduent id: "+ theID);
		Student myStudent = studentDAO.findById(theID);

		// display student
		System.out.println("Found the student: "+myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student object");
		Student tempStudent1 = new Student("rohith", "rao", "rohith@gmail.com");
		Student tempStudent2 = new Student("srujan", "varma", "srujan@gmail.com");
		Student tempStudent3 = new Student("ajay", "reddy", "ajay@gmail.com");

		// save the student objects
		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}


	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Prathihas", "Podduturi", "prathihas@gmail.com");


		// save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of saved student
		System.out.println("Saved student: Generated Id: "+ tempStudent.getId());
	}


}
