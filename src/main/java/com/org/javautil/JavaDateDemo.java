package com.org.javautil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaDateDemo {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d.toString());
		
	      SimpleDateFormat dateformat = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	      
	      System.out.println(dateformat.format(d));
	      
	      

	}

}
