package com.Qspider.StudentLaptop.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Qspider.StudentLaptop.Entity.Laptop;
import com.Qspider.StudentLaptop.Exception.LaptopListNotFound;
import com.Qspider.StudentLaptop.Exception.laptopNotFound;
import com.Qspider.StudentLaptop.dao.LaptopDao;
import com.Qspider.StudentLaptop.util.ResponceStructure;
@Service
public class LaptopService 
{
	@Autowired
	LaptopDao dao;
	
	public ResponseEntity<ResponceStructure<Laptop>> saveLaptop(Laptop laptop) {
		Laptop l=dao.saveLaptop(laptop);
		if(l != null) {
			ResponceStructure<Laptop> structure = new ResponceStructure<Laptop>();
			structure.setMsg("Laptop save Success");
			structure.setCode(HttpStatus.CREATED.value());
			structure.setData(l);
			return new ResponseEntity<ResponceStructure<Laptop>>(structure, HttpStatus.CREATED);
		}
		return null;
	}
	
	public ResponseEntity<ResponceStructure<Laptop>> findOnelaptop(int id) {
		Laptop l=dao.findOneLaptop(id);
		if(l != null) {
			ResponceStructure<Laptop> structure = new ResponceStructure<Laptop>();
			structure.setMsg("Laptop found Success");
			structure.setCode(HttpStatus.FOUND.value());
			structure.setData(l);
			return new ResponseEntity<ResponceStructure<Laptop>>(structure, HttpStatus.FOUND);
		}
		throw new laptopNotFound("Laptop not found given Id");
	}
	
	public ResponseEntity<ResponceStructure<Laptop>> deleteOneLaptop(int id) {
		Laptop l= dao.findOneLaptop(id);
		if(l != null) {
			ResponceStructure<Laptop> structure = new ResponceStructure<Laptop>();
			structure.setMsg("Laptop deleted Success");
			structure.setCode(HttpStatus.OK.value());
			structure.setData(dao.deleteOneLaptop(id));
			return new ResponseEntity<ResponceStructure<Laptop>>(structure, HttpStatus.OK);
		}
		throw new laptopNotFound("Laptop not found given Id");
	}
	
	public ResponseEntity<ResponceStructure<Laptop>> updateLaptop(int id , Laptop l) {
		Laptop lap=dao.findOneLaptop(id);
		if(lap != null) {
			ResponceStructure<Laptop> structure = new ResponceStructure<Laptop>();
			structure.setMsg("Laptop update Success");
			structure.setCode(HttpStatus.CREATED.value());
			structure.setData(dao.updateLaptop(id, l));
			return new ResponseEntity<ResponceStructure<Laptop>>(structure, HttpStatus.OK);
		}
		throw new laptopNotFound("Laptop not found given Id");
	}
	
	public ResponseEntity<ResponceStructure<List<Laptop>>> findAllLaptop(){
		ResponceStructure<List<Laptop>> str = new ResponceStructure<List<Laptop>>();
		List<Laptop> findAllLaptop = new ArrayList<Laptop>();
		if(!findAllLaptop.isEmpty()) {
			str.setMsg("Found All Laptop Succeess");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(findAllLaptop);
			return new ResponseEntity<ResponceStructure<List<Laptop>>>(str, HttpStatus.FOUND);
		}
		throw new LaptopListNotFound("No Laptop Available in your DataBase");
	}
}