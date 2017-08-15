package com.bit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 */
public class BuySellStockPrice {
	public static int maxprofit(List<Integer> stockdata){
		//sorting - nlogn
		int n=stockdata.size();
		int max=0;
		int index1=-1;
		int index2=-1;
		for(int i=0;i<n-1;i++){
				int j=i+1;
				while(j<n && stockdata.get(i) < stockdata.get(j)){
					int curr=stockdata.get(j) - stockdata.get(i);
					if(curr > max){
						max=curr; 
						index1=i;
						index2=j;
					}			
					j++;
				}

		}
		return max;
	}
	
	public static void main(String[] args){
		ArrayList<Integer> data = new ArrayList<Integer>();
		data.add(7);
		data.add(1);
		data.add(5);
		data.add(3);
		data.add(6);
		data.add(4);
		System.out.println(Arrays.toString(data.toArray()));
		System.out.println(BuySellStockPrice.maxprofit(data));
	}
	

}
