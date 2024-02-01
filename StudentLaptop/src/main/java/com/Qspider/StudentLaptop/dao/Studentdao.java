package com.Qspider.StudentLaptop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qspider.StudentLaptop.dto.Student;
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
		return repo.findById(id).get();
	}
	
	public List<Student> findAllStudent() {
		return repo.findAll();
	}
	
	public String deleteOneStudent(int id) {
		Student st=repo.findById(id).get();
		String name=st.getStudentName();
		repo.deleteById(id);
		System.out.println(name);
		return name +" is Deleted Successfully";
		
	}
	
	public String deleteAllStudent() {
		repo.deleteAll();
		return "All student deleted Successfully";
	}
	
	public Student updateStudent(int id , Student s) {
		Student exSt=repo.findById(id).get();
		if(exSt.getStudentId()==id) {
			exSt.setStudentId(id);
			exSt.setStudentName(s.getStudentName());
			exSt.setStudentEmail(s.getStudentEmail());
			exSt.setStudentPassword(s.getStudentPassword());
			repo.save(exSt);
		}
		return s;
	}
}