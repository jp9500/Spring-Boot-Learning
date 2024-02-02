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
		return dao.findOneLaptop(id);
	}
	
	public String deleteOneLaptop(int id) {
		return dao.deleteOneLaptop(id);
	}
	
	public String deleAllLaptop() {
		return dao.deleteAllLaptop();
	}
	
	public Laptop updateLaptop(int id , Laptop l) {
		return dao.updateLaptop(id, l);
	}

}