package com.goura.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 986. Interval List Intersections
 * 
 * Given two lists of closed intervals, each list of intervals is pairwise
 * disjoint and in sorted order. Return the intersection of these two interval
 * lists.
 * 
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real
 * numbers x with a <= x <= b. The intersection of two closed intervals is a set
 * of real numbers that is either empty, or can be represented as a closed
 * interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 * 
 * @author Gourahari Das
 *
 */
public class IntervalListIntersections {

	static class Interval {
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
			return String.format("[%d, %d]", start, end);
		}
	}

	public static void main(String[] args) {
		intervalIntersection(
				new Interval[] {
						new Interval(0, 2),
						new Interval(5, 10),
						new Interval(13, 23),
						new Interval(24, 25)
				}, new Interval[] {
						new Interval(1, 5),
						new Interval(8, 12),
						new Interval(15, 24),
						new Interval(25, 26)
				});

		intervalIntersection(
				new Interval[] {
						new Interval(10, 12),
						new Interval(18, 19)
				}, new Interval[] {
						new Interval(1, 6),
						new Interval(8, 11),
						new Interval(13, 17),
						new Interval(19, 20)
				});
	}

	public static Interval[] intervalIntersection(Interval[] A, Interval[] B) {
		List<Interval> list = new ArrayList<>();
		int i = 0, j = 0, end, start;

		while (i < A.length && j < B.length) {
			start = Math.max(A[i].start, B[j].start);
			end = Math.min(A[i].end, B[j].end);
			if (start <= end) {
				list.add(new Interval(start, end));
			}
			if (A[i].end == end) {
				i++;
			} else {
				j++;
			}
		}

		System.out.println(list);
		Interval[] arr = new Interval[list.size()];
		return list.toArray(arr);
	}
}
