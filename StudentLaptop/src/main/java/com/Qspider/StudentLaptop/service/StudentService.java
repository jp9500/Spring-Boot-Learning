package com.Qspider.StudentLaptop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Qspider.StudentLaptop.dao.Studentdao;
import com.Qspider.StudentLaptop.dto.Student;
@Service
public class StudentService 
{
	@Autowired
	Studentdao dao;
	
	public Student saveStudent(Student s) {
		return dao.saveStudent(s);
	}
	
	public Student findOneStudent(int id) {
		return dao.findOneStudent(id);
	}
	
	public List<Student> findAllStudent() {
		return dao.findAllStudent();
	}
	
	public String deleteOneStudent(int id) {
		return dao.deleteOneStudent(id);
	}
	
	public String deleteAllStudent() {
		return dao.deleteAllStudent();
	}
	
	public Student updateStudent(int id ,Student st) {
		return dao.updateStudent(id, st);
		
	}
}
