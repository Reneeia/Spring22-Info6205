package neu.jia.assignment02;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (newInterval == null) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();

        if (intervals == null || intervals.length == 0) {
            result.add(newInterval);
            int[][] res = new int[result.size()][2];
            return result.toArray(res);
        }

        for (int[] i : intervals) {
            if (newInterval == null || i[1] < newInterval[0]) {
                result.add(i);
            } else if (i[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = null;
                result.add(i);
            } else {
                newInterval[0] = Math.min(newInterval[0], i[0]);
                newInterval[1] = Math.max(newInterval[1], i[1]);
            }
        }

        if (newInterval == null) {
            int[][] res = new int[result.size()][2];
            return result.toArray(res);
        } else {
            result.add(newInterval);
            int[][] res = new int[result.size()][2];
            return result.toArray(res);
        }
    }
}
