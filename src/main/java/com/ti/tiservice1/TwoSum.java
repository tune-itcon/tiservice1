/**
 * 
 */
package com.ti.tiservice1;

/**
 * @author duansubramaniam
 *
 */
public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int expected = 9;
		int[] myarray = {2,7,11,15};
		
		boolean foundVal = false;
		int pos1 = 0, pos2 = 0;
		
		for(int i=0; i< myarray.length; i++) {
			int initValue = myarray[i];
			for(int y=i+1; y <myarray.length; y++) {
				int matchVal = myarray[y];
				if(initValue + matchVal == expected) {
					foundVal = true;
					pos1 = i;
					pos2 = y;
					break;
				}
			}
		}
		System.out.println("found array: pos1:  " + pos1 + " pos 2: " + pos2);
	}

}
