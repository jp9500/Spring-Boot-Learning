package com.Qspider.StudentLaptop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Qspider.StudentLaptop.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>
{
	
}