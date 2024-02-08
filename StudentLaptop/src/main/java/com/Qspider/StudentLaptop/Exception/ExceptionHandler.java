package com.Qspider.StudentLaptop.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Qspider.StudentLaptop.util.ResponceStructure;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponceStructure<String>> LaptopNotFoundException(laptopNotFound ex){
		ResponceStructure<String> str=new ResponceStructure<String>();
		str.setMsg("Laptop does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponceStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponceStructure<String>> StudentNotFoundException(StudentNotFound ex){
		ResponceStructure<String> str=new ResponceStructure<String>();
		str.setMsg("Student does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponceStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponceStructure<String>> StudentListNotFoundException(StudentListNotFound ex){
		ResponceStructure<String> str=new ResponceStructure<String>();
		str.setMsg("Student List does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponceStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponceStructure<String>> LaptopListNotFoundException(LaptopListNotFound ex){
		ResponceStructure<String> str=new ResponceStructure<String>();
		str.setMsg("Laptop List does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponceStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
}