package com.greedy.level03.hard.emp.run;

import java.util.Scanner;

import com.greedy.level03.hard.emp.model.dto.EmployeeDTO;

public class Application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		EmployeeDTO employee = new EmployeeDTO();
		
		employee.setNumber(sc.nextInt());
		sc.nextLine();
		employee.setName(sc.nextLine());
		employee.setDept(sc.nextLine());
		employee.setJob(sc.nextLine());
		employee.setAge(sc.nextInt());
		employee.setGender(sc.next().charAt(0));
		employee.setSalary(sc.nextInt());
		employee.setBonusPoint(sc.nextDouble());
		sc.nextLine();
		employee.setPhone(sc.nextLine());
		employee.setAddress(sc.nextLine());
		
		System.out.println(employee.getNumber());
		System.out.println(employee.getName());
		System.out.println(employee.getDept());
		System.out.println(employee.getJob());
		System.out.println(employee.getAge());
		System.out.println(employee.getGender());
		System.out.println(employee.getSalary());
		System.out.println(employee.getBonusPoint());
		System.out.println(employee.getPhone());
		System.out.println(employee.getAddress());
		
	}
}
