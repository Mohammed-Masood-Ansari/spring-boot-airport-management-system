package com.ty.airportmanagementsystem.dao;

import java.time.LocalTime;

public class A {

	public static void main(String[] args) {
		
		LocalTime ar = LocalTime.of(15, 58);
		LocalTime dep = LocalTime.of(13, 37);
		
		int a=ar.getHour()-dep.getHour();
		
		int min=0;
		if(ar.getMinute()>dep.getMinute()) {
			min = ar.getMinute()-dep.getMinute();
		}else {
			min = dep.getMinute()-ar.getMinute();
		}
		
		String totalhours = a+":"+min;
		
		System.out.println(totalhours);
		
	}
}
