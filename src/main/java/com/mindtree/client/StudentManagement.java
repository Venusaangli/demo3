package com.mindtree.client;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mindtree.dao.StudentDao;
import com.mindtree.entity.Student;

public class StudentManagement {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("StudentManagement");
		EntityManager entityManager = factory.createEntityManager();
		Student student = new Student();
		StudentDao studentDao = new StudentDao();
		int choice = 0;
		do {
			choice = getChoice();
			switch (choice) {
			case 1:
				student = getStudent();
				studentDao.addStudent(entityManager, student);
				break;
			case 2:
				int idtoupdate=getId();
				String newName=getName();
				studentDao.updateStudentDetails(entityManager, idtoupdate, newName);
				break;
			case 3:
				int idtodelete=getId();
				studentDao.deleteStudent(entityManager, idtodelete);
				break;
			case 4:
				int newid=getId();
				studentDao.getStudentDetails(entityManager, newid);
				break;
			case 5:
				List<Student>res=studentDao.getAllStudents(entityManager);
				for(Student i:res) {
					System.out.println("Student id: "+i.getId());
					System.out.println("Student Name: "+i.getName());
					System.out.println("Student Age: "+i.getAge());
				}
					break;
				
			case 6:
				System.out.println("Thank you!!!!!!!!!!!");
				System.exit(1);
				break;
				default:
					System.out.println("Invalid Choice");
					break;
				
			}
		} while (choice >= 0 && choice <= 5);
	}

	private static String getName() {
		System.out.println("enter new Name");
		sc.nextLine();
		String name=sc.nextLine();
		return name;
	}

	private static Student getStudent() {
		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		System.out.println("Enter Student Name");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter Student Age");
		int age = sc.nextInt();
		return new Student(id, name, age);
	}

	private static int getChoice() {
		System.out.println("Enter 1: To Add Student");
		System.out.println("Enter 2: To Update Student Name");
		System.out.println("Enter 3: To Delete Student Details");
		System.out.println("Enter 4: To get Student Detail by Id");
		System.out.println("Enter 5: Display All Students");
		System.out.println("Enter 6: To Exit");
		int choice = sc.nextInt();
		return choice;
	}
	private static int getId() {
		System.out.println("Enter Id");
		int id=sc.nextInt();
		return id;
	}

}
