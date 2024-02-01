package com.Qspider.StudentLaptop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qspider.StudentLaptop.dto.Laptop;
import com.Qspider.StudentLaptop.repo.LaptopRepo;

@Repository
public class LaptopDao 
{
	@Autowired
	LaptopRepo lap;
	
	public Laptop saveLaptop(Laptop laptop) {
		return lap.save(laptop);
	}

	public List<Laptop> findAllLaptop() {
		return lap.findAll();
	}
	
	public Laptop findLaptop(int id) {
		return lap.findById(id).get();
	}
}