package com.santosh.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyCollection<T> implements Iterable<T> {

	private List<T> aList;
	
	public MyCollection(T[] t) {
		aList = new ArrayList<T>(Arrays.asList(t));
	}
	
	public Iterator<T> iterator() {
		//Create a FilteringIterator to filter Strings starting with 'A'.
		return new FilteringIterator<T>(new MyIterator(aList), 
				(x) -> ((String)x).startsWith("A") );
	}
	
	public void add(T t) {
		aList.add(t);
	}
}