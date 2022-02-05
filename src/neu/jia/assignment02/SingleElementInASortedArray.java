package neu.jia.assignment02;

public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        if (right == 0) {
            return nums[right];
        } else if (nums[1] != nums[0]) {
            return nums[0];
        } else if (nums[right] != nums[right - 1]) {
            return nums[right];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            if ((mid % 2) == 0 && nums[mid] == nums[mid + 1] || (mid % 2) == 1 && nums[mid] == nums[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
