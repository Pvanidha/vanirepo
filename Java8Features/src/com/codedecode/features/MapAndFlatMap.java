package com.codedecode.features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMap {

	public static void main (String args[]) {
		
		//Get the list of emailIds
		List<Employee> empList = Stream.of(
				new Employee(1, "Vanidha", "vanidha.parthiban@gmail.com", Arrays.asList("9677888033,9790355960")),
				new Employee(2, "Ashok", "sembu.ashok@gmail.com", Arrays.asList("9677888033,9790355960")),
				new Employee(3, "Sreya", "sreya.sa@gmail.com", Arrays.asList("9677881233,9790355660"))
				).collect(Collectors.toList());
		
		System.out.println("List of employee emailIds: " + empList.stream().map(emp->emp.getEmailId()).collect(Collectors.toList()));
		
		//Get the list of phone nos
		
		System.out.println("List of employee phone nos: " +empList.stream().flatMap(emp->emp.getPhoneNoList().stream()).collect(Collectors.toList()));
		
		//Sorting by name in descending order
		System.out.println("Sorting custom object by id: "+empList.stream().
				sorted(Comparator.comparing(Employee::getName).reversed())
				.collect(Collectors.toList()));
		
		//convert list to map
		Map<Integer, Employee> empMap = empList.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
		System.out.println("Employee map: "+ empMap);
		
		//sort map by key on custom object
		Map<Integer, Employee> sortedMapByKey = empMap.entrySet().stream()
		.sorted(Map.Entry.comparingByKey())
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		
		System.out.println("Sorted map by key: "+sortedMapByKey);
		
		//sort map by key on custom object
		Map<Integer, Employee> sortedMapByValue = empMap.entrySet().stream()
		.sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getName)))
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		
		System.out.println("Sorted map by value: "+sortedMapByValue);
		
	}
}
