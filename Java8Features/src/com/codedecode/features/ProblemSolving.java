package com.codedecode.features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProblemSolving {

	public static void main(String args[]) {
		
		// Find the occurance of each character in a string
		String sampleString = "ilovejava";
		Map<String, Long> map = Arrays.stream(sampleString.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Occurance map: "+map);
		
		//Find all duplicate elements from a given string
		
		String duplicateList = map.entrySet().stream()
					.filter(x-> x.getValue()>1)
					.map(x->x.getKey())
					.collect(Collectors.joining(""));
		
		System.out.println("Duplicate String: "+duplicateList);
		
		//find unique characters in a string
		
		List<String> uniqueList = map.entrySet().stream()
				.filter(x->x.getValue()==1)
				.map(x->x.getKey())
				.collect(Collectors.toList());
		
		System.out.println("Unique character in a String: "+uniqueList);
		
		//Find first non repeat element in a string
		
		Map<String, Long> linkedHashmap = Arrays.stream(sampleString.split(""))
		.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		
		
		String firstNonRepeatElement = linkedHashmap.entrySet().stream()
		.filter(x->x.getValue()==1)
		.map(x->x.getKey())
		.findFirst().get();
		
		System.out.println("First non repeat element: "+ firstNonRepeatElement);
		
		//Find unique numbers from integer array and sum it
		List<Integer> intList = Arrays.asList(1,2,3,3,4,5,5,6);
		Map<Integer, Long> intMap = intList.stream()
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println("intmap: "+intMap);
		
		Integer sumOfDuplicateValues = intMap.entrySet().stream()
		.filter(x->x.getValue()>1)
		.map(x->x.getKey())
		.reduce(Integer::sum).get();
		
		System.out.println("Sum of duplicate values: " + sumOfDuplicateValues);
		
		//Find 2nd highest number from an array
		int numbers[] = {5,9,11,2,8,21,1};
		Integer highNumber = Arrays.stream(numbers).boxed()
		.sorted(Comparator.reverseOrder())
		.skip(1)
		.findFirst().get();
		
		//Descending of numbers
		System.out.println("Numbers in reverse order: " + Arrays.stream(numbers).boxed()
		.sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
		
		System.out.println("2nd highest no: " + highNumber);
		
		//Return all the numbers which starts with 1
		System.out.println("Numbers that startswith 1: " + 
		Arrays.stream(numbers).boxed().sorted()
		.map(x->x+"")
		.filter(s->s.startsWith("1"))
		.collect(Collectors.toList()));
		
		//Use string.join()
		System.out.println("Use string join: " + String.join("-", Arrays.asList("1", "2", "3")));
		
		//I have 10 elements and I dont want first and last element
		IntStream.rangeClosed(0, 10)
		.skip(1)
		.limit(9)
		.forEach(System.out::println);
		
		//Find longest string from an Array
		
	}
}
