package neu.jia.info6205MidTerm.question04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> intervalList = new ArrayList<>();

        if(intervals == null || intervals.length == 0){
            return new int[0][0];
        }
        //early to late start
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        
        int[] prev = intervals[0];
        for(int i = 0; i < intervals.length; i++){
            int[] cur = intervals[i];

            //overlap
            if(prev[1] >= cur[0]){
                cur[0] = prev[0];
                cur[1] = Math.max(prev[1], cur[1]);
                //no overlap
            }else{
                intervalList.add(prev);
            }
            prev = cur;
        }
        intervalList.add(prev);

        //covert into 2D array
        int[][] result = new int[intervalList.size()][2];
        for(int i = 0; i < intervalList.size();i++){
            result[i] = intervalList.get(i);
        }
        return result;
    }
}
