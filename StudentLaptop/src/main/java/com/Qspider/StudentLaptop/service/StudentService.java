package com.Qspider.StudentLaptop.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Qspider.StudentLaptop.Entity.Laptop;
import com.Qspider.StudentLaptop.Entity.Student;
import com.Qspider.StudentLaptop.Exception.StudentListNotFound;
import com.Qspider.StudentLaptop.Exception.StudentNotFound;
import com.Qspider.StudentLaptop.Exception.laptopNotFound;
import com.Qspider.StudentLaptop.dao.LaptopDao;
import com.Qspider.StudentLaptop.dao.Studentdao;
import com.Qspider.StudentLaptop.dto.StudentDto;
import com.Qspider.StudentLaptop.util.ResponceStructure;
@Service
public class StudentService 
{
	@Autowired
	Studentdao dao;
	@Autowired
	LaptopDao lapdao;

	public ResponseEntity<ResponceStructure<StudentDto>> saveStudent(Student s) {
			Student st = dao.saveStudent(s);
			StudentDto dto =new StudentDto();	
			ModelMapper mapper = new ModelMapper();
			mapper.map(st, dto);
			ResponceStructure<StudentDto> structure = new ResponceStructure<StudentDto>();
			structure.setMsg("Student Save Success");
			structure.setCode(HttpStatus.CREATED.value());
			structure.setData(dto);
			return new ResponseEntity<ResponceStructure<StudentDto>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponceStructure<Student>> findOneStudent(int id) {
		Student st=dao.findOneStudent(id);
		if(st != null) {
			ResponceStructure<Student> structure = new ResponceStructure<Student>();
			structure.setMsg("Student Found Success");
			structure.setCode(HttpStatus.FOUND.value());
			structure.setData(st);
			return new ResponseEntity<ResponceStructure<Student>>(structure, HttpStatus.FOUND);
		}
		throw new StudentNotFound("Student not found Given Id");
	}
	
	public ResponseEntity<ResponceStructure<Student>> deleteOneStudent(int id) {
		Student st =dao.findOneStudent(id);
		if(st != null) {
			ResponceStructure<Student> structure = new ResponceStructure<Student>();
			structure.setMsg("Student Deleted Success");
			structure.setCode(HttpStatus.OK.value());
			structure.setData(dao.deleteOneStudent(id));
			return new ResponseEntity<ResponceStructure<Student>>(structure, HttpStatus.OK);
		}
		throw new StudentNotFound("Student not found Given Id");
	}
	
	public ResponseEntity<ResponceStructure<Student>> updateStudent(int id ,Student st) {
		Student s =dao.findOneStudent(id);
		if(s != null) {
			ResponceStructure<Student> structure = new ResponceStructure<Student>();
			structure.setMsg("Student Update Success");
			structure.setCode(HttpStatus.OK.value());
			structure.setData(dao.updateStudent(id, st));
			return new ResponseEntity<ResponceStructure<Student>>(structure, HttpStatus.OK);
		}
		throw new StudentNotFound("Student not found Given Id");
	}
	
	public ResponseEntity<ResponceStructure<Student>> assignLaptop(int studentId,int laptopId){
		Student student = dao.findOneStudent(studentId);
		
		Laptop laptop = lapdao.findOneLaptop(laptopId);
		
		if(laptop != null) {
			if(student != null) {
				student.setLap(laptop);
				ResponceStructure<Student> structure = new ResponceStructure<Student>();
				structure.setData(dao.updateStudent(student.getStudentId(), student));
				structure.setMsg("laptop assigned");
				structure.setCode(HttpStatus.OK.value());
				
				return new ResponseEntity<ResponceStructure<Student>>(structure,HttpStatus.OK);
			}
			throw new StudentNotFound("Student not found Given Id");
		}
		
		throw new laptopNotFound("Laptop not found Given Id");
	}
	
	public ResponseEntity<ResponceStructure<List<Student>>> findAllStudent(){
		ResponceStructure<List<Student>> structure = new ResponceStructure<List<Student>>();
		List<Student> findAllstd =dao.findAllStudent();
		if(!findAllstd.isEmpty()) {
			structure.setMsg("All student Found");
			structure.setCode(HttpStatus.FOUND.value());
			structure.setData(findAllstd);
			return new ResponseEntity<ResponceStructure<List<Student>>>(structure, HttpStatus.FOUND);
		}
		throw new StudentListNotFound("No Student Available in database");
	}
	
	public ResponseEntity<ResponceStructure<Student>> deleteLapUsingStdId(int stdId){
		ResponceStructure<Student> structure = new ResponceStructure<Student>();
		Student st=dao.findOneStudent(stdId);
		if(st != null) {
			Laptop lap = st.getLap();
			if(lap != null) {
				st.setLap(null);
				structure.setMsg("Deleted Relation Success ");
				structure.setCode(HttpStatus.OK.value());
				structure.setData(dao.updateStudent(stdId, st));
				lapdao.deleteOneLaptop(lap.getLaptopId());
				return new ResponseEntity<ResponceStructure<Student>>(structure, HttpStatus.OK);
			}
			throw new laptopNotFound("Laptop not found Given Id");
		}
		throw new StudentNotFound("Student not found Given Id");
	}
	
	public ResponseEntity<ResponceStructure<Student>> RemoveLapUsingStdId(int stdId){
		ResponceStructure<Student> structure = new ResponceStructure<Student>();
		Student st=dao.findOneStudent(stdId);
		if(st != null) {
			Laptop lap = st.getLap();
			if(lap != null) {
				st.setLap(null);
				structure.setMsg("Removed Relation Success ");
				structure.setCode(HttpStatus.OK.value());
				structure.setData(dao.updateStudent(stdId, st));
				return new ResponseEntity<ResponceStructure<Student>>(structure, HttpStatus.OK);
			}
			throw new laptopNotFound("Laptop not found Given Id");
		}
		throw new StudentNotFound("Student not found Given Id");
	}
}