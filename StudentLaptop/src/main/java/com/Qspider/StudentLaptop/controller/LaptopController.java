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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Qspider.StudentLaptop.Entity.Laptop;
import com.Qspider.StudentLaptop.service.LaptopService;
import com.Qspider.StudentLaptop.util.ResponceStructure;
@RestController
@RequestMapping("laptop")
public class LaptopController 
{
	@Autowired
	LaptopService service;
	
	@PostMapping("save")
	public ResponseEntity<ResponceStructure<Laptop>> saveLaptop(@RequestBody Laptop laptop) {
		return service.saveLaptop(laptop);
	}
	
	@GetMapping("findone")
	public ResponseEntity<ResponceStructure<Laptop>> findOneLaptop(@RequestParam int id) {
		return service.findOnelaptop(id);
	}
	
	@DeleteMapping("deleteone")
	public ResponseEntity<ResponceStructure<Laptop>> deleteLaptop(@RequestParam int id) {
		return service.deleteOneLaptop(id);
	}
	
	@PutMapping("update")
	public ResponseEntity<ResponceStructure<Laptop>> updateLaptop(@RequestParam int id ,@RequestBody Laptop l) {
		return service.updateLaptop(id, l);
	}
	@GetMapping("findAll")
	public ResponseEntity<ResponceStructure<List<Laptop>>> findAllLaptop() {
		return service.findAllLaptop();
	}
	
}