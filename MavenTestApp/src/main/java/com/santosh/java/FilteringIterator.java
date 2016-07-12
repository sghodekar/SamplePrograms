package com.santosh.java;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilteringIterator<E> implements Iterator<E> {

	Iterator<E> myIterator;
	IObjectTest myTest;
	
	public FilteringIterator(Iterator<E> myIterator, IObjectTest mytest)  {
		this.myIterator = myIterator;
		this.myTest = mytest;
	}
	
	public boolean hasNext() {
		return myIterator.hasNext();
	}

	public E next() {
		if (hasNext()) {		
			E nextElement = myIterator.next();
			while (!myTest.test(nextElement)){
				if (myIterator.hasNext()) {
					nextElement = myIterator.next();
				}
				else {
					return null;
				}
			}
			return nextElement;
	    } else {
	        throw new NoSuchElementException("There are no elements size " );
	    }					

	}

}