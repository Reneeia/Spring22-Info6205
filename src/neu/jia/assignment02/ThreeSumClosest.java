package neu.jia.assignment02;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        //edge check, if nums is null or nums' elements less than 3, return -1
        if (nums == null || nums.length < 3) {
            return -1;
        }
        //initiate result 0, minGap max value
        int result = 0;
        int minGap = Integer.MAX_VALUE;
        //sort the array nums
        Arrays.sort(nums);

        //iterate the num by 3 pointer, i, left = i + 1. right = num.length
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < minGap) {
                    minGap = Math.abs(sum - target);
                    result = sum;
                }

                if (target == sum) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
