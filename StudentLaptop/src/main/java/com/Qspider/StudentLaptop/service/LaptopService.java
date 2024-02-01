package com.Qspider.StudentLaptop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Qspider.StudentLaptop.dao.LaptopDao;
import com.Qspider.StudentLaptop.dto.Laptop;
@Service
public class LaptopService 
{
	@Autowired
	LaptopDao dao;
	
	public Laptop saveLaptop(Laptop laptop) {
		return dao.saveLaptop(laptop);
	}
	
	public List<Laptop> findAllLaptop() {
		return dao.findAllLaptop();
	}
	
	public Laptop findlaptop(int id) {
		return dao.findLaptop(id);
	}
}
