package com.codedecode.features;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStream {

	public static void main(String args[]) {
		
		IntStream in = IntStream.range(0, 100);
		List<List<Integer>> intList = Arrays.asList(in.boxed().collect(Collectors.toList()));
		long start = System.currentTimeMillis();
		intList.stream().forEach(number -> {
			
			System.out.println("Stream:: Thread to print: "+number+ ":: "+ Thread.currentThread());
		});
		long end = System.currentTimeMillis();
		System.out.println("Time taken to print with stream: "+ Long.valueOf(end-start));
		
		long start1 = System.currentTimeMillis();
		intList.parallelStream().forEach(number -> {
			
			System.out.println("Parallel Stream:: Thread to print: "+number+ ":: "+ Thread.currentThread());
		});
		long end1 = System.currentTimeMillis();
		System.out.println("Time taken to print with parallel stream: "+ Long.valueOf(end1-start1));
		
	}
}
