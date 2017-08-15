package com.bit.array;

import java.util.ArrayList;
/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:

 Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

 Example 2:

 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 Make sure the returned intervals are also sorted.
 */
import java.util.Arrays;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class MergeIntervals {

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		
		if(intervals.size() == 0 && newInterval == null){
			return intervals;
		}
		
		ArrayList<Interval> temp = new ArrayList<Interval>();
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		if (newInterval.end < newInterval.start) {
			newInterval = new Interval(newInterval.end, newInterval.start);
		}

		boolean added = false;

		for (Interval interval : intervals) {
			 if (interval.end < newInterval.start) {
				temp.add(interval);
			} else if (interval.start > newInterval.end) {
				temp.add(newInterval);
				temp.add(interval);
				added=true;
			} else if ((interval.end >= newInterval.start)
					|| (interval.start <= newInterval.end)) {

				temp.add(new Interval(Math.min(interval.start,
						newInterval.start), Math.max(interval.end,
						newInterval.end)));
				added = true;
			}

		}

		if (!added) {
			if (temp.size() > 0 && temp.get(0).start > newInterval.start) {
				result.add(newInterval);
				result.addAll(temp);
			}else{
				temp.add(newInterval);
				result = temp;
			}
			
		}
		// merge overlap intervals
		if (added) {
			// [[1 2], [3 9], [4 9], [4 10], [12 16]]

			Interval pre = temp.get(0);
			for (int i = 1; i < temp.size(); i++) {
				if (temp.get(i).start > pre.end) {
					result.add(pre);
					pre = temp.get(i);

				} else {
					Interval merge = new Interval(pre.start, Math.max(pre.end,
							temp.get(i).end));
					pre = merge;

				}

			}
			result.add(pre);
		}
		return result;

	}

	public static void main(String[] args) {
		ArrayList<Interval> data = new ArrayList<Interval>();
		// A : [ (1, 2), (3, 6) ]
		// B : (10, 8)
////		data.add(new Interval(1, 2));
//		data.add(new Interval(3, 6));
//		
//		// data.add(new Interval(6,7));
//		 data.add(new Interval(8,10));
//		// data.add(new Interval(12,16));
		 
		 
//		 data.add(new Interval(1, 3));
//		 data.add(new Interval(6, 9));

		System.out.println(Arrays.toString(data.toArray()));
		System.out.println(Arrays.deepToString(MergeIntervals.insert(data,
				new Interval(1, 1)).toArray()));
	}

}
