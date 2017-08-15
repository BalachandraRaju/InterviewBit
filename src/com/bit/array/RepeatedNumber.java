package com.bit.array;

import java.util.HashSet;
import java.util.List;

public class RepeatedNumber {
	public int repeatedNumber(final List<Integer> a) {
		HashSet<Integer> data= new HashSet<Integer>();
		int repeatedNumber = -1;
		for(Integer k:a){
			 if(!data.add(k)){
				repeatedNumber = k;
				break;
			 }
		}
		return repeatedNumber;
	}
	
	public static void main(String[] args){
		
	}

}
