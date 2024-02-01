package com.Qspider.StudentLaptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Qspider.StudentLaptop.dto.Student;
import com.Qspider.StudentLaptop.service.StudentService;
@RestController
@RequestMapping("student")
public class StudentController 
{
	@Autowired
	StudentService service;
	
	@PostMapping("save")
	public Student saveStudent(@RequestBody Student s) {
		System.out.println(s.getStudentEmail()+" "+s.getStudentName());
		return service.saveStudent(s);
	}
	
	@GetMapping("findone")
	public Student findOneStudent(int id) {
		return service.findOneStudent(id);
	}
	
	@GetMapping("findall")
	public List<Student> findAllStudent() {
		return service.findAllStudent();
	}
	
	@DeleteMapping("delete")
	public String deleteOneStudent(int id) {
		return service.deleteOneStudent(id);
	}
	
	@DeleteMapping("deleteall")
	public String deleteAllStudent() {
		return service.deleteAllStudent();
	}
	
	@PutMapping("update")
	public Student updateStudent(int id , @ RequestBody Student st) {
		return service.updateStudent(id, st);
	}
	
}