package com.bit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Given an array of integers, sort the array into a wave like array and return it, 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
 NOTE : f there are multiple answers possible, return the one thats lexicographically smallest. 
 For example ,[2, 1, 4, 3]
 */
public class WaveArray {
	public static ArrayList<Integer> wave(ArrayList<Integer> a) {
		// for even index , i >i+1 else i < i+1
		Collections.sort(a);
		for(int i=0;i<a.size()-1;i++){
			if(i%2 == 0){
				if(!(a.get(i) >= a.get(i+1))){
					Collections.swap(a,i,i+1);
				}
			} else {
				if(!(a.get(i) <= a.get(i+1))){
					Collections.swap(a,i,i+1);
				}
			}
		}
		return a;
	}
	
	public static void main(String[] args){
		ArrayList<Integer> data = new ArrayList<Integer>();
		data.add(1);
		data.add(2);
		data.add(3);
		data.add(2);
		data.add(5);
		System.out.println(Arrays.toString(data.toArray()));
		System.out.println(Arrays.toString(WaveArray.wave(data).toArray()));
	}
}
