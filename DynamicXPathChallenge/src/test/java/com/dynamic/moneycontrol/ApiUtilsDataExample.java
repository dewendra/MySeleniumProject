package com.dynamic.moneycontrol;

import java.sql.DatabaseMetaData;
import java.util.List;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ApiUtilsDataExample {

	public static List<String>getSortedListFromAPI(){
		
		Response res=given()
		.when()
		.get("https://api.example.com/users?sortBy=name&order=asc")
		.then()
		.statusCode(200)
		.extract()
		.response();
		
		List<String> apiNameStrings=res.jsonPath().getList("data.name");
		
		return apiNameStrings;
		
	}
}
