/**
 * 
 */
package com.ti.tiservice1;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

/**
 * @author duansubramaniam
 *
 */
public class CommonTests {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void stringArrayTest() {
		String[] strings = {"a","b","c","d"};
		
		Predicate<String> isString = (value) -> { 
			return value == "b" || value == "d";
		};
		
		Function<String, String> compose = (value)  ->{
				return value + "x";
		};
		
		List<String> list = Stream.of(strings)
				.filter(isString)
				.map(compose)
				.collect(Collectors.toList());
		
		assertEquals(list.get(0), "bx");
		assertEquals(list.get(1), "dx");
		
	}
	
	@Test
	public void stringArrayOrderTest() {
		String[] strings = {"a","f", "b", "d", "c","e"};
		
		Predicate<String> isString = (value) -> { 
			return value == "b" || value == "d";
		};
		
		Function<String, String> compose = (value)  ->{
				return value + "x";
		};
		
		List<String> list = Stream.of(strings)
				.sorted(Comparator.comparing(compose))
				.collect(Collectors.toList());
		
		System.out.println("order: " + list);
		
		assertEquals(list.get(0), "a");
		assertEquals(list.get(1), "b");
		
		System.out.println("order: " + list);
		
	}
	
	@Test
	public void stringArrayReduceTest() {
		String[] strings = {"a","b","c","d"};
		
		Predicate<String> isString = (value) -> { 
			return value == "b" || value == "d";
		};
		
		Function<String, String> compose = (value)  ->{
				return value + "x";
		};
		
		String value = Stream.of(strings)
				.filter(isString)
				.map(compose)
				.reduce("s:",(i,j) -> i + "-" + j);
		
		System.out.println(value);
		
		//assertTrue(value.isPresent());
		assertEquals(value, "s:-bx-dx");
		
	}
	
	@Test
	public void intArrayTest() {
		
	}
	
	
	public List<String> getListValues(){
	      HashMap<String,String> map = new HashMap<String,String>();
	    map.put("1","q1");
	    map.put("2","f1");
	    map.put("3","q1");
	    
	      List<String> list = map.values().stream()
	      .filter(v -> v.startsWith("q"))
	      .collect(Collectors.toList());
	      return list;
	    }
	          
	    
	    
	    @Test
	    public void test(){
	      
	        List<String> list = getListValues();
	      
	        assertEquals(list.size(),2);
	      
	        assertEquals(list.get(0), "q1");
	      
	      
	    }
	    
	    @Test
	    public void longtest() {
	    	Long v1 = null;
	    	Long v2 = null;
	    	
	    	if(v1 > v2) {
	    		System.out.println("v1 > v2");
	    	}else {
	    		System.out.println("else case");
	    	}
	    }
	    
	    

}
