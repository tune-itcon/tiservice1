/**
 * 
 */
package com.ti.tiservice1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author duansubramaniam
 *
 */
public class JavaTest {

	public static class Student {
        private String name;
        private int score;
        
        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
        
        public int getScore() {
            return score;
        }
        
        public String getName() {
            return name;
        }
    }
    
    public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {
    	Comparator<String> comp = (name1, name2) -> name1.compareTo(name2);
    	return 
        		students
        .filter(s -> s.score >= passingScore)
        .map(Student::getName)
        .sorted(comp.reversed())
       
        .collect(Collectors.toList());
        
    	
    	HashMap<String, String> map = new HashMap<String, String>();
    	
    	List<String> list = map.values().stream()
    	.filter(v -> v.startsWith("q"))
    	.collect(Collectors.toList());
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {


		List<Student> students = new ArrayList<Student>();

        students.add(new Student("Mike", 80));
        students.add(new Student("James", 57));
        students.add(new Student("Alan", 21));

        studentsThatPass(students.stream(), 50).forEach(System.out::println);        

	}

}

