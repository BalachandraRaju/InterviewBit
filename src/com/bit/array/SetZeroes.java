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

	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		int r = 1;
		int c = 1;
		// check 1st column
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).get(0) == 0) {
				c = 0;
				break;
			}
		}

		// check 1st row
		for (int j = 0; j < a.get(0).size(); j++) {
			if (a.get(0).get(j) == 0) {
				r = 0;
				break;
			}
		}

		// now check remaining rows
		for (int i = 1; i < a.size(); i++) {
			int x = a.get(i).get(0);
			if (x == 0) {
				a.get(i).set(0, 0);
			} else {
				for (int j = 1; j < a.get(i).size(); j++) {
					if (a.get(i).get(j) == 0) {
						a.get(i).set(0, 0);
						break;
					}
				}
			}
		}

		// now check remaining cols
		for (int j = 1; j < a.get(0).size(); j++) {
			int x = a.get(0).get(j);
			if (x == 0) {
				a.get(0).set(j, 0);
			} else {
				for (int i = 1; i < a.size(); i++) {
					if (a.get(i).get(j) == 0) {
						a.get(0).set(j, 0);
						break;
					}
				}
			}
		}

		
		


		// set remaining rows n cols
		for (int i = 1; i < a.size(); i++) {
			for (int j = 1; j < a.get(i).size(); j++) {
				if (a.get(0).get(j) == 1 && a.get(i).get(0) == 1) {
					a.get(i).set(j, 1);
				} else {
					a.get(i).set(j, 0);
				}
			}
		}
		
		// update 1st column
		for (int i = 1; i < a.size(); i++) {
			a.get(i).set(0,c);
		}

		// update 1st row
		for (int j = 1; j < a.get(0).size(); j++) {
			a.get(0).set(j,r);
		}
		// row 0 and col 0
		int k = r & c;
		a.get(0).set(0, k);

	}

	public static void main(String[] args) {
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(1);
		row1.add(0);
		row1.add(1);
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		row2.add(1);
		row2.add(1);
		row2.add(1);
		ArrayList<Integer> row3 = new ArrayList<Integer>();
		row3.add(1);
		row3.add(1);
		row3.add(1);

		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		matrix.add(row1);
		matrix.add(row2);
		matrix.add(row3);
		System.out.println(Arrays.toString(matrix.toArray()));

		setZeroes(matrix);
		System.out.println(Arrays.toString(matrix.toArray()));

	}

}
