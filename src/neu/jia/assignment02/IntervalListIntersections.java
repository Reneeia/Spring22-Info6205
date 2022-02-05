package neu.jia.assignment02;

public class IntervalListIntersections {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                mid = right - 1;
            }
        }

        if (nums[left] >= target) {
            return left;
        } else if (target > nums[left] && target <= nums[right]) {
            return right;
        } else {
            return nums.length;
        }
    }
}
