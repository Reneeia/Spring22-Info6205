package neu.jia.assignment02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    //override comparator to help sort the intervals by the start time
    private static class CustomComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new CustomComparator());

        //priority queue/ minHeap stores the ending times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }

}
