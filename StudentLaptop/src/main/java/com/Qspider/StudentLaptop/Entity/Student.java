package com.Qspider.StudentLaptop.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Component
@Getter
@Setter
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int StudentId;
	private String StudentName;
	private String StudentEmail;
	private String StudentPassword;
	@OneToOne(cascade = CascadeType.ALL)
	private Laptop lap;
	
	
}
