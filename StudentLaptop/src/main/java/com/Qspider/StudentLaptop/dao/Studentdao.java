package com.Qspider.StudentLaptop.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qspider.StudentLaptop.Entity.Student;
import com.Qspider.StudentLaptop.repo.StudentRepo;

@Repository
public class Studentdao 
{
	@Autowired
	StudentRepo repo;
	
	public Student saveStudent(Student s) {
		return repo.save(s);
	}
	
	public Student findOneStudent(int id) {
		Optional<Student> opSt=repo.findById(id);
		if(opSt.isPresent()) {
			return opSt.get();
		}
		return null;
	}
	
	public Student deleteOneStudent(int id) {
		Student st=repo.findById(id).get();
		repo.deleteById(id);
		return st;
	}
	
	public Student updateStudent(int id , Student s) {
		Student exSt=repo.findById(id).get();
		if(exSt != null) {
			s.setStudentId(id);
			repo.save(s);
			return s;
		}
		return null;
	}
	
	public List<Student> findAllStudent() {
		return repo.findAll();
	}
}