package neu.jia.assignment01;

import java.util.ArrayList;
import java.util.List;

class MajorityElement {
    public class Pair {
        int val;
        int freq;

        //Constructor
        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        //Create 2 candidates, if there are new value except 2 candidates, both candidates' frequency--
        // if there is only one candidate,add new value and its frequency is 1
        Pair candidateOne = new Pair(Integer.MIN_VALUE, 0);
        Pair candidateTwo = new Pair(Integer.MIN_VALUE, 0);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidateOne.val) {
                candidateOne.freq++;
            } else if (nums[i] == candidateTwo.val) {
                candidateTwo.freq++;
            } else if (candidateOne.freq == 0) {
                candidateOne.val = nums[i];
                candidateOne.freq = 1;
            } else if (candidateTwo.freq == 0) {
                candidateTwo.val = nums[i];
                candidateTwo.freq = 1;
            } else {
                candidateOne.freq--;
                candidateTwo.freq--;
            }
        }

        //iterate array to count both candidate's frequency
        candidateOne.freq = 0;
        candidateTwo.freq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidateOne.val) candidateOne.freq++;
            if (nums[i] == candidateTwo.val) candidateTwo.freq++;
        }

        //check whether the frequency > n/3
        int thirdLength = nums.length / 3;
        if (candidateOne.freq > thirdLength) result.add(candidateOne.val);
        if (candidateTwo.freq > thirdLength) result.add(candidateTwo.val);
        return result;
    }
}