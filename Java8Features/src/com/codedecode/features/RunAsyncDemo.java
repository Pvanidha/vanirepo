package com.codedecode.features;

import java.io.File;
import java.io.FileReader;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RunAsyncDemo {

	public Void getEmployees(File jsonFile) throws InterruptedException, ExecutionException {
		
		ObjectMapper mapper = new ObjectMapper();
		Executor executor = Executors.newFixedThreadPool(10);
		
		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {

			try {

				JSONParser jsonParser = new JSONParser();
				FileReader reader = new FileReader(jsonFile);

				JSONObject obj = (JSONObject) jsonParser.parse(reader);
				JSONArray empList = (JSONArray) obj.get("Employees");
				for (int j = 0; j < 10; j++) {
					for (int i = 0; i < empList.size(); i++) {
						JSONObject jsonObject = (JSONObject) empList.get(i);
						System.out.println("Employee:: " + jsonObject);
					}
					System.out.println("Thread: " + Thread.currentThread().getName());
				}
				// employeeList.forEach(System.out::println);
			} catch (Exception e) {
				e.printStackTrace();
			}
		},executor);
		return runAsyncFuture.get();
	}
	
	public static void main (String args[]) throws InterruptedException, ExecutionException, ParseException {
		
		RunAsyncDemo runAsyncDemo = new RunAsyncDemo();
		runAsyncDemo.getEmployees(new File("EmployeeJson.json"));
		
		
	}
}
