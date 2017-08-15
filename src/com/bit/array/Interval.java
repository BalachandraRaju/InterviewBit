package com.bit.array;

public class Interval implements Comparable<Interval> {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return "[" + start + " " + end + "]";
	}

	@Override
	public int compareTo(Interval o) {
		if (start != o.start) {
			return start - o.start;
		} else
			return end - o.end;
	}
}
