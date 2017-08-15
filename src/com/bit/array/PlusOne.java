package com.bit.array;

import java.util.Arrays;

/**
 * input : two arrays , each a number represented by an array
 * output : sum of two numbers
 * @author gchandu
 *
 */
public class PlusOne {
	public static int[] sum(int[] a1,int[] a2){
		
		
		return null;
	}
	
	// increment by 1
	public static int[] plusOne(int[] a){
		int n= a.length;
		a[n-1]=a[n-1]+1;
		
		int i=n-1;
		while(a[i] == 10 && i > 0){
			a[i-1]= a[i-1]+1;
			a[i]=0;
			i--;
		}
		
		if(a[0]==10){
			int[] newArray = new int[n+1];
			newArray[0]=1;
			newArray[1]=0;
			//copy the elements
//			Arrays.cop
		}
		return a;
	}
	
	public static void main(String[] args){
		//138 > 139
		//901 > 902
		int[] a = {1,9,9};
		System.out.println(Arrays.toString(PlusOne.plusOne(a)));
	}
}
