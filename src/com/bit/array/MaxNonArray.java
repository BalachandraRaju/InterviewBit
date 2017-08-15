package com.bit.array;

import java.util.ArrayList;
import java.util.List;

/*
 * Find out the maximum sub-array of non negative numbers from an array.
 The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

 Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 Example
 A : [1, 2, 5, -7, 2, 3]
 The two sub-arrays are [1, 2, 5] [2, 3].
 The answer is [1, 2, 5] as its sum is larger than [2, 3]
 NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 NOTE 2: If there is still a tie, then return the segment with minimum starting index
 */
public class MaxNonArray {

	public ArrayList<Integer> maxset1(ArrayList<Integer> a) {
		// list of sub-arrays
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		List<Integer> maxList = new ArrayList<Integer>();
		List<Integer> sublist = new ArrayList<Integer>();

		int start = 0;
		int end = 0;

		int currentSum = 0;
		int maxSum = 0;
		int index = 0;
		try {
			while (start < a.size()) {
				end = findMaxSet(a, start);
				if (start != end) {
					currentSum = findSum(a, start, end);
					sublist = a.subList(start, end);

					if (currentSum == maxSum) {
						if (maxList.size() < sublist.size()) {
							maxList = sublist;
							index = start;
						} else if (maxList.size() == sublist.size()) {
							// keep track of index now
							if (start <= index) {

							}
						}
					}
					if (currentSum > maxSum) {
						maxSum = currentSum;

						maxList = sublist;
						index = start;
					}
				}
				start = end + 1;
			}

		} catch (ArithmeticException e) {
			maxList = a.subList(start, end);
		}

		ArrayList<Integer> returnSet = new ArrayList<Integer>();
		for (int i = 0; i < maxList.size(); i++) {
			returnSet.add(maxList.get(i));
		}

		return returnSet;
	}

	private int findSum(List<Integer> a, int start, int end)
			throws ArithmeticException {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum = safeAdd(sum, a.get(i));
		}
		return sum;
	}

	private int safeAdd(int left, int right) throws ArithmeticException {
		if (right > 0 ? left > Integer.MAX_VALUE - right
				: left < Integer.MIN_VALUE - right) {
			throw new ArithmeticException("Integer overflow");
		}
		return left + right;
	}

	private int findMaxSet(ArrayList<Integer> a, int startIndex) {
		int endIndex = startIndex;
		for (int i = startIndex; i < a.size(); i++) {
			if (a.get(i) < 0) {
				endIndex = i;
				break;
			}
		}

		return endIndex;
	}

	public static void main(String[] args) {
		System.out.println(1967513926 > Integer.MAX_VALUE);
		// [ 756898537, -1973594324, -2038664370, -184803526, 1424268980 ]
		// [0 0 -1 0]
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(756898537);
		input.add(1424268980);
		input.add(-1973594324);
		input.add(-2038664370);
		input.add(1424268980);
		input.add(84353895);
		input.add(2001100545);
//		input.add(1);
		input.add(1424268980);

		MaxNonArray max = new MaxNonArray();
		ArrayList<Integer> result = max.maxset2(input);
		System.out.println(result);

	}

	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
		int currentsum = 0;
		int maxsum = -1;
		int startIndex = 0;
		int endIndex = -1;
		int len=0;
		boolean start = true;
		boolean end = false;

		for (int i = 0; i < a.size(); i++) {

			if (a.get(i) >= 0) {
				try {
					currentsum = safeAdd(currentsum, a.get(i));

					if (currentsum == maxsum) {
						if(start){
//							check the indices
//							if(i > ())
						}
						if (!start) {
							endIndex = i;
						}
						
					} else if (currentsum > maxsum) {
						if (start) {
							startIndex = i;
							start = false;
						}

						maxsum = currentsum;
						endIndex = i;
					}
				} catch (ArithmeticException e) {
					endIndex = i;
					break;
				}

			} else {
				currentsum = 0;
				start = true;
			}
		}

		ArrayList<Integer> returnSet = new ArrayList<Integer>();
		for (int i = startIndex; i <= endIndex; i++) {
			returnSet.add(a.get(i));
		}

		return returnSet;

	}
	
	public ArrayList<Integer> maxset2(ArrayList<Integer> a) {
		int currentsum = 0;
		int maxsum = -1;
		int startIndex = 0;
		int endIndex = -1;
		int len=0;
		int maxlen=0;

		for (int i = 0; i < a.size(); i++) {

			if (a.get(i) >= 0) {
				try {
					len++;
					currentsum = safeAdd(currentsum, a.get(i));
					if (i == (a.size() - 1)) {
						if (currentsum == maxsum) {
							if (len > maxlen) {
								maxlen = len;
								endIndex = i;
							}

						} else if (currentsum > maxsum) {
							maxsum = currentsum;
							endIndex = i;
							maxlen = len;
						}
					}
				}catch (ArithmeticException e) {
					endIndex = i;
					currentsum=Integer.MAX_VALUE;
					maxlen=len;
				}
			}
			else {
				if(currentsum == maxsum){
					if(len > maxlen){
						maxlen=len;
						endIndex=i-1;
					}
					
				} else if(currentsum > maxsum){
					maxsum = currentsum;
					endIndex=i-1;
					maxlen=len;
				}
				currentsum = 0;
				len=0;
			}
			
			
		}

		startIndex=endIndex-maxlen+1;
		ArrayList<Integer> returnSet = new ArrayList<Integer>();
		for (int i = startIndex; i <= endIndex; i++) {
			returnSet.add(a.get(i));
		}

		return returnSet;

	}

}
