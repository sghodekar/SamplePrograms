package com.santosh.java;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;

public class MyCollectionTest  {

	@Test
	public final void testNext_BaseCase()  
	{
		MyCollection<String> s = new MyCollection<String>(new String[]{"XYZ"});
		s.add("LMN");
		s.add("ABC");
		Iterator<String> itr = s.iterator(); // Returns FilteringIterator
		assertTrue(itr.hasNext()); 
		assertEquals("ABC", itr.next()); // next skips LMN and next satisfies ABC 
	}
	
}