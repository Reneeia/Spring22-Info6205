package neu.jia.assignment02;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        if(nums[0] < nums[nums.length-1]){
            return nums[0];
        }

        int left = 0;
        int right = nums.length -1;

        while(left + 1 < right){
            int mid = left + (right - left) / 2;

            if(mid > 0 && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }

            if(nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }

            if(nums[left] < nums[mid]){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
