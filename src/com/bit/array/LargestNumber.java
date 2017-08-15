package com.bit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

27, 271 or 12, 121 ?
 */
public class LargestNumber {
	// DO NOT MODIFY THE LIST
		public static String largestNumber1(final List<Integer> a) {
			StringBuilder s = new StringBuilder();
			if(a.size() > 0){
				//check for all zeros
				boolean allzeros=false;
				for(int i=0;i<a.size();i++){
					if(a.get(i) != 0){
						break;
					}
					if(i==a.size()-1 && a.get(i)==0){
						allzeros = true;
						return "0";
					}
				}
				
				Object[] intArray = a.toArray();
				Arrays.sort(intArray,new Comparator<Object>() {
					StringBuilder s1;
					StringBuilder s2;
					@Override
					public int compare(Object o1, Object o2) {
						s1= new StringBuilder(o1.toString()).append((int)o2);
						s2=new StringBuilder(o2.toString()).append((int)o1);
						
						return Integer.parseInt(s2.toString())-Integer.parseInt(s1.toString());
						
					}
				});
				
				for(int i=0;i<intArray.length;i++){
					s.append(intArray[i]);
				}
				
			}
			
			return s.toString();
		}
		
		public static void main(String[] args){
//			A : [ 472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412 ]
					
			ArrayList<Integer> data = new ArrayList<Integer>();
			data.add(472);
			data.add(663);
			data.add(964);
			data.add(722);
			data.add(4);
			data.add(412);
			
			System.out.println(LargestNumber.largestNumber(data));
//			System.out.println(Integer.parseInt("9775076860243460"));
			
		}
		
		public static String largestNumber(final List<Integer> a) {
			StringBuilder output = new StringBuilder();
			if(a.size() > 0){
				
				for(int i=0;i<a.size();i++){
					if(a.get(i) != 0){
						break;
					}
					if(i==a.size()-1 && a.get(i)==0){
						return "0";
					}
				}
				
				String[] str= new String[a.size()];
				for(int i=0;i<a.size();i++){
					str[i]=a.get(i).toString();
				}
				
				Arrays.sort(str,new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						return (o2+o1).compareTo(o1+o2);
					}
				});
				
				for(int i=0;i<str.length;i++){
					output.append(str[i]);
				}
				
			}
			return output.toString();
		}
}
