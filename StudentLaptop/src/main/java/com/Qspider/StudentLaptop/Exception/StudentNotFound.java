package com.Qspider.StudentLaptop.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentNotFound extends RuntimeException{
	
	String msg;
}
