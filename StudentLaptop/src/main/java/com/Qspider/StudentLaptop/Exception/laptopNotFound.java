package com.Qspider.StudentLaptop.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class laptopNotFound extends RuntimeException{
	
	String msg;
	
}
