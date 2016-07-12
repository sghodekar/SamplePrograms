package com.santosh.java;

//Junit

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FilteringIteratorTest  {
	
	@Test
	public final void TestExactMatchCase()
	{	    
		List<String> list = new ArrayList<String>();
	    list.add("First");
	    list.add("Second");
	    list.add("Third");
  
	    //create new filtering Iterator from standard ArrayList Iterator
	    FilteringIterator<String> filteredList =
       new FilteringIterator<String>(list.iterator(), (x) -> x.equals("Second"));
  
	    assertTrue(filteredList.hasNext()); 
      assertEquals("Second",filteredList.next());
}

}
