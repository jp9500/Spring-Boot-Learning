package com.Qspider.StudentLaptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Qspider.StudentLaptop.Entity.Student;
import com.Qspider.StudentLaptop.dto.StudentDto;
import com.Qspider.StudentLaptop.service.StudentService;
import com.Qspider.StudentLaptop.util.ResponceStructure;
@RestController
@RequestMapping("student")
public class StudentController 
{
	@Autowired
	StudentService service;
	
	@PostMapping("save")
	public ResponseEntity<ResponceStructure<StudentDto>> saveStudent(@RequestBody Student s) {
		System.out.println(s.getStudentEmail()+" "+s.getStudentName());
		return service.saveStudent(s);
	}
	
	@GetMapping("findone")
	public ResponseEntity<ResponceStructure<Student>> findOneStudent(int id) {
		return service.findOneStudent(id);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<ResponceStructure<Student>> deleteOneStudent(int id) {
		return service.deleteOneStudent(id);
	}
	
	@PutMapping("update")
	public ResponseEntity<ResponceStructure<Student>> updateStudent(int id , @ RequestBody Student st) {
		return service.updateStudent(id, st);
	}
	
	@PutMapping("assign")
	public ResponseEntity<ResponceStructure<Student>> assignLaptopToStudent(int studentId , int laptopId){
		
		return service.assignLaptop(studentId, laptopId);
	}
	@GetMapping("findAll")
	public ResponseEntity<ResponceStructure<List<Student>>> findAllStudent(){
		return service.findAllStudent();
	}
	
	@DeleteMapping("deleteUsingStdId")
	public ResponseEntity<ResponceStructure<Student>> deletelaptopUsingStdId(int stdId){
		return service.deleteLapUsingStdId(stdId);
	}
	
	@DeleteMapping("remove")
	public ResponseEntity<ResponceStructure<Student>> removelaptopUsingStdId(int stdId){
		return service.RemoveLapUsingStdId(stdId);
	}
	
}