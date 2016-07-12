package com.santosh.java;

import java.util.stream.IntStream;

/**
 * Find 2 to power of n using java 8.
 * 
 * @author Santosh
 *
 */
public class powerto2 extends Object{

	public static void main(String[] args) {
		IntStream.range(0, 10)
		.mapToDouble(i -> i)
		.map(i-> Math.pow(2, i))
		.forEach (System.out::println);
		
	}
}
