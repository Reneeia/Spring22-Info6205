package neu.jia.assignment02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //creat a result list to store results
        List<List<Integer>> result = new ArrayList<>();
        //sort nums
        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int curTar = target - nums[i] - nums[j];
                twoSum(nums, j + 1, curTar, result, j, i);
            }
        }
        return result;
    }

    //method do two sum
    private void twoSum(int[] nums, int start, int target, List<List<Integer>> result, int j, int i) {

        int end = nums.length - 1;

        while (start < end) {
            int curSum = nums[start] + nums[end];

            if (curSum == target) {
                result.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[start], nums[end]}));
                start++;

                //start++ to skip duplicates
                while (start < end && nums[start] == nums[start - 1]) start++;

            } else if (curSum > target) {
                end--;
            } else {
                start++;
            }
        }
    }
}
