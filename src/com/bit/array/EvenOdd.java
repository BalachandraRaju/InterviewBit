package com.bit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * separate the items into even and odd
 * @author gchandu
 *
 */
public class EvenOdd {
	
	public static ArrayList arrange(ArrayList<Integer> input){
		int n=input.size();
		int even=0;
		int odd=n-1;
	
		while(even <= odd){
			if(input.get(even) % 2 == 0){
				even++;
			}else {
				//swap with odd
				Collections.swap(input, even, odd);
				odd--;
			}
		}
		return input;
	}
	
	public static void main(String[] args){
		ArrayList<Integer> data = new ArrayList<Integer>();
		data.add(7);
		data.add(4);
		data.add(5);
		data.add(3);
		data.add(2);
		System.out.println(Arrays.toString(data.toArray()));
		System.out.println(Arrays.toString(EvenOdd.arrange(data).toArray()));

	}

}
