package neu.jia.info6205MidTerm.question04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class deleteOverlapIntervals {

    //comparator
    private class CustomComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }

    public int deleteOverlapIntervals(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        
        if (intervals == null || intervals.length == 0) {
            return -1;
        }

        //sort the intervals
        Arrays.sort(intervals, new CustomComparator());

        result.add(intervals[0]);

        //iterate intervals
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
