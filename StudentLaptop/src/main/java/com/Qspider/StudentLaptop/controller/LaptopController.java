package com.Qspider.StudentLaptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Qspider.StudentLaptop.dto.Laptop;
import com.Qspider.StudentLaptop.service.LaptopService;
@RestController
@RequestMapping("laptop")
public class LaptopController 
{
	@Autowired
	LaptopService service;
	
	@PostMapping("save")
	public Laptop saveLaptop(@RequestBody Laptop laptop) {
		return service.saveLaptop(laptop);
	}

	@GetMapping("findall")
	public List<Laptop> findAllLaptop() {
		return service.findAllLaptop();
	}
	
	@GetMapping("findone")
	public Laptop findLaptop(@RequestParam int id) {
		return service.findlaptop(id);
	}
	
	@DeleteMapping("deleteone")
	public String deleteLaptop(@RequestParam int id) {
		return service.deleteOneLaptop(id);
	}
	
	@DeleteMapping("deleteall")
	public String deleteAllLaptop() {
		return service.deleAllLaptop();
	}
	
	@PutMapping("update")
	public Laptop updateLaptop(@RequestParam int id ,@RequestBody Laptop l) {
		return service.updateLaptop(id, l);
	}
}