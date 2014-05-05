package org.vikastaneja.examples;

import org.vikastaneja.examples.Intervals;
import java.util.*;

/**
 * Created by vikastaneja on 5/5/14.
 */
public class MiscProblems {

	public static void mergeIntervals(List<Intervals> intervals) {
		if (intervals == null) {
			throw new RuntimeException("List of intervals can't be null");
		}

		if (intervals.size() <= 1) {
			System.out.println("No need for processing the list");
			return;
		}

		// Commenting this until sort is available for Interval class
		// Collections.sort(intervals);

		Stack<Interval> stack = new Stack<Interval>();
		for (Interval interval : intervals) {
			if (stack.empty()) {
				stack.push(interval);
				continue;
			}

			Interval temp = stack.pop();
			if (temp.end < interval.start) {
				stack.push(temp);
				stack.push(interval);
			} else {
				temp.end = interval.end;
				stack.push(temp);
			}
		}

		// Now stack contain all merged intervals
		intervals = null;
		intervals = new ArrayList<Interval>();
		while(!stack.empty()) {
			intervals.add(stack.pop(), 0);
		}
	}
}