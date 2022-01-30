package neu.jia.assignment01;

public class SortColors {
    public void sortColors(int[] nums) {
        //[0,i)0s
        //[i,j)1s
        //[j,k]unexplored
        //(k,end)2s
        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, j, i);
                i++;
                j++;
            } else if (nums[j] == 1) {
                j++;
            } else {
                swap(nums, j, k);
                k--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
