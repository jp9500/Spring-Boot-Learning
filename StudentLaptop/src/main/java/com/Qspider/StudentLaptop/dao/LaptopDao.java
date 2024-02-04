package com.Qspider.StudentLaptop.dao;

import java.util.List;
import java.util.Optional;

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
		Optional<Laptop> opLap=lap.findById(id);
		if(opLap.isPresent()) {
			return opLap.get();
		}
		return null;
	}
	
	public String deleteOneLaptop(int id) {
		Laptop l=lap.findById(id).get();
		String name=l.getLaptopBrand();
		lap.deleteById(id);
		return name+" is Deleted Successfully";
	}
	
	public String deleteAllLaptop() {
		lap.deleteAll();
		return "All laptops are Deleted";
	}
	
	public Laptop updateLaptop(int id , Laptop l) {
		Laptop exLap=lap.findById(id).get();
		if(exLap != null) {
			l.setLaptopId(id);
			lap.save(l);
		}
		return l;
	}
}