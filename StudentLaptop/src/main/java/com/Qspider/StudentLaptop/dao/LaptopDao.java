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
	
	public Laptop findOneLaptop(int id) {
		return lap.findById(id).get();
	}
	
	public String deleteOneLaptop(int id) {
		Laptop l=lap.findById(id).get();
		String name=l.getLaptopBrand();
		return name+" is Deleted Successfully";
	}
	
	public String deleteAllLaptop() {
		lap.deleteAll();
		return "All laptops are Deleted";
	}
	
	public Laptop updateLaptop(int id , Laptop l) {
		Laptop exLap=lap.findById(id).get();
		if(exLap.getLaptopId()==id) {
			exLap.setLaptopId(id);
			exLap.setLaptopName(l.getLaptopName());
			exLap.setLaptopBrand(l.getLaptopBrand());
		}
		return exLap;
	}
}