package com.demo;

public class Employee {

	private int id;
	private String empName;
	private int age;
	
	

	public Employee() {
		
	}

	public Employee(int id, String empName, int age) {
		super();
		this.id = id;
		this.empName = empName;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", age=" + age + "]";
	}

}
