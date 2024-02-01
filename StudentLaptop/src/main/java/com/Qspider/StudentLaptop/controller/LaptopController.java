package com.Qspider.StudentLaptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Laptop findLaptop(int id) {
		return service.findlaptop(id);
	}
}