package com.Qspider.StudentLaptop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Qspider.StudentLaptop.dto.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Integer>
{

}
