package neu.jia.assignment02;

import java.util.ArrayList;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //check edge cases
        if (firstList == null || firstList.length == 0 && secondList == null || secondList.length == 0) {
            return new int[0][0];
        }

        //create 2 pointers to iterate firstList and secondList
        int i = 0;
        int j = 0;

        //create an arraylist to store the result first
        ArrayList<int[]> res = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            int max = Math.max(firstList[i][0], secondList[j][0]);
            int min = Math.min(firstList[i][1], secondList[j][1]);

            if (max <= min) {
                res.add(new int[]{max, min});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        //copy arraylist in to 2D array
        int[][] result = new int[res.size()][2];
        for (i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
