package neu.jia.assignment02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class NonOverlappingIntervals {

    //override comparator to help sort the intervals by the start time
    private static class CustomComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return -1;
        }

        Arrays.sort(intervals, new CustomComparator());

        //create a linked list to store the intervals could keep in
        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);

        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = result.getLast();
            if (last[1] > current[0]) {
                last[1] = Math.min(last[1], current[1]);
                result.removeLast();
                result.addLast(last);
            } else {
                result.addLast(current);
            }
        }
        return intervals.length - result.size();
    }
}
