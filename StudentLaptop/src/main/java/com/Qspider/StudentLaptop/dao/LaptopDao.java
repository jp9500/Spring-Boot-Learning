package com.Qspider.StudentLaptop.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qspider.StudentLaptop.Entity.Laptop;
import com.Qspider.StudentLaptop.repo.LaptopRepo;

@Repository
public class LaptopDao 
{
	@Autowired
	LaptopRepo lap;
	
	public Laptop saveLaptop(Laptop laptop) {
		return lap.save(laptop);
	}

	public Laptop findOneLaptop(int lapId) {
		Optional<Laptop> opLap=lap.findById(lapId);
		if(opLap.isPresent()) {
			return opLap.get();
		}
		return null;
	}
	
	public Laptop deleteOneLaptop(int id) {
		Laptop l=lap.findById(id).get();
		String name=l.getLaptopBrand();
		lap.deleteById(id);
		return l;
	}
	
	public Laptop updateLaptop(int id , Laptop l) {
		Laptop exLap=lap.findById(id).get();
		if(exLap != null) {
			l.setLaptopId(id);
			lap.save(l);
		}
		return l;
	}
	
	public List<Laptop> findAllLaptop() {
		return lap.findAll();
	}
}