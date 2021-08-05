package com.mindtree.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.mindtree.entity.Student;

public class StudentDao {
public void addStudent(EntityManager entityManager,Student newStudent) {
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(newStudent);
	entityTransaction.commit();
}

public void getStudentDetails(EntityManager entityManager,int newid) {
	Student foundStudent=entityManager.find(Student.class,newid);
	if(foundStudent!=null) {
	System.out.println("=======================================");
	System.out.println("Student Name: "+foundStudent.getName());
	System.out.println("Student Id: "+foundStudent.getId());
	System.out.println("Student Age: "+foundStudent.getAge());
	System.out.println("=========================================");
	}else {
		System.out.println("================");
		System.out.println("Id not Found");
		System.out.println("=================");
	}
	//entityManager.close();
}
public void updateStudentDetails(EntityManager entityManager,int newId,String newName) {
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	Student studentUpdate=entityManager.find(Student.class,newId);
	studentUpdate.setName(newName);
	entityTransaction.commit();
	
}
public void deleteStudent(EntityManager entityManager,int newid) {
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	Student studentDelete=entityManager.find(Student.class,newid);
	entityManager.remove(studentDelete);
	entityTransaction.commit();
}
public List<Student> getAllStudents(EntityManager entityManager) {
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	String hql="from Student";
	Query query=entityManager.createQuery(hql);
	List<Student> result=query.getResultList();
	entityTransaction.commit();
	return result;
}
}
