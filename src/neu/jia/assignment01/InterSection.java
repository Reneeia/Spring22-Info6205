package neu.jia.assignment01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InterSection {
    public int[] intersection(int[] nums1, int[] nums2) {

        //sort 2 given arrays, and create 2 pointer i,j
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;

        //create a hashset named intersection to save intersection numbers
        Set<Integer> intersection = new HashSet();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersection.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        //copy the result from intersection to result array
        int[] result = new int[intersection.size()];
        int k = 0;
        for (int num : intersection) {
            result[k] = num;
            k++;
        }
        return result;
    }
}
