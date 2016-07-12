package com.santosh.java;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyIterator<E> implements Iterator<E> {
	
	private int index = 0;
	private List<E>	aList;
	private boolean canremove = false;

	public MyIterator(List<E> iList) {
		aList = iList;
	}
	
	public boolean hasNext() {
		return index < aList.size();
	}

	public E next() {
		if(hasNext()) {
			canremove = true;
            return aList.get(index++);
        } else {
            throw new NoSuchElementException("There are no elements size = " + aList.size());
        }		
	}
	
	public void remove() {
        if(index <= 0) {
            throw new IllegalStateException("You can't delete element before first next() method call");
        }
        if (!canremove) {
			throw new IllegalStateException("Can only remove() content after a call to next()");
		}
        canremove = false;
		aList.remove(--index);
	}

}