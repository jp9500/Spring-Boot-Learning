package com.Qspider.StudentLaptop.util;

import lombok.Data;

@Data
public class ResponceStructure<T> 
{
	private String msg;
	private int code;
	private T data;
}
