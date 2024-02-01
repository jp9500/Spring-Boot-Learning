package com.Qspider.StudentLaptop.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component

public class Laptop
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int LaptopId;
	private String LaptopName;
	private String LaptopBrand;
	
}
