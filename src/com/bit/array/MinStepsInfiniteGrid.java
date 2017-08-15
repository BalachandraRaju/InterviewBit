package com.bit.array;

import java.util.ArrayList;

public class MinStepsInfiniteGrid {
	 public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
		 int n=X.size();
		 int total=0;
		 int j=0,k=0;
		 for(int i=1;i<n;i++){
			 j=Math.abs(X.get(i)-X.get(i-1));
			 k=Math.abs(Y.get(i)-Y.get(i-1));
			 
			 if(j >= k){
				 total += j;
			 }else {
				 total +=k;
			 }
		 }
		 
		 return total;
	 }

	 
}
