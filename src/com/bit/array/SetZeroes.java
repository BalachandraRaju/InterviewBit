package com.bit.array;

import java.util.ArrayList;

/**
 * Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.

Do it in place.

Example

Given array A as

1 0 1
1 1 1 
1 1 1
On returning, the array A should be :

0 0 0
1 0 1
1 0 1
 * @author gchandu
 *
 */
public class SetZeroes {

	public ArrayList<ArrayList<Integer>> setZeroes(ArrayList<ArrayList<Integer>> a) {
		int R=1;
		int C=1;
		if(a.isEmpty()){
			return a;
		}
		//check 1st row
		for(int j=0;j<a.get(0).size();j++){
			if(a.get(0).get(j) == 0){
				R=0;
				break;
			}
		}
		
		//check first column
		for(int i=0;i<a.size();i++){
			if(a.get(i).get(0) == 0){
				C=0;
				break;
			}
		}
		
		
		
		for(int i=1;i<a.size();i++){
			for(int j=1;j<a.get(i).size();j++){
				if(a.get(i).get(j)==0){
					a.get(i).set(0,0);
					break;
				}
			}
		}
		
		for(int j=1;j<a.get(0).size();j++){
			for(int i=1;i<a.size();i++){
				if(a.get(i).get(j)==0){
					a.get(0).set(j,0);
					break;
				}
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
