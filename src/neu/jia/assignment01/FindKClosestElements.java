package neu.jia.assignment01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] array, int k, int x) {
        // first find the place near to the x
        if (array == null || array.length == 0 || k == 0) {
            return new ArrayList<>();
        }
        int closetIdx = findClosetIdx(array, x);
        Integer[] res = new Integer[k];
        int left = closetIdx - 1;
        int right = closetIdx + 1;
        res[0] = array[closetIdx];
        for (int i = 1; i < k; i++) {
            if (left < 0) {
                res[i] = array[right++];
            } else if (right >= array.length) {
                res[i] = array[left--];
            } else {
                int deltaLeft = Math.abs(x - array[left]);
                int deltaRight = Math.abs(x - array[right]);
                if (deltaLeft < deltaRight) {
                    res[i] = array[left--];
                } else if (deltaLeft > deltaRight) {
                    res[i] = array[right++];
                } else {
                    res[i] = array[left--];
                }
            }
        }
        Arrays.sort(res);
        return Arrays.asList(res);
    }

    private int findClosetIdx(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target < array[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int deltaEnd = Math.abs(target - array[end]);
        int deltaStart = Math.abs(target - array[start]);
        return deltaEnd < deltaStart ? end : start;
    }
}
