package com.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class EmployeeRunner {

	public static void main(String[] args) throws JsonProcessingException {

		Employee employee = new Employee(101, "John", 21);
		System.out.println(employee);
		
		//By using Gson Library
		// Serialization-Converting Java object to JSON Object
		System.out.println("---------------Gson Library---------------");
		Gson gson = new Gson();
		String json = gson.toJson(employee);
		System.out.println(json);

		// Deserialization-Convert JSON data to Java Object
		String gsonData = "{\"id\":102,\"empName\":\"Pihu\",\"age\":26}";
		Employee fromJson = gson.fromJson(gsonData, Employee.class);
		System.out.println(fromJson);
		
		
		//By Jacson Library
		// Serialization-Converting Java object to JSON Object
		System.out.println("---------------Jacson Library---------------");
		ObjectMapper mapper=new ObjectMapper();
		String jsonData=mapper.writeValueAsString(employee);
		String jsonData1=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		System.out.println(jsonData);
		System.out.println(jsonData1);
		
		// Deserialization-Convert JSON data to Java Object
		String jacksonData = "{\"id\":102,\"empName\":\"Pihu\",\"age\":26}";
		Employee fromJackson=mapper.readValue(jacksonData, Employee.class);
		System.out.println(fromJackson);
		
		
		
	}

}
