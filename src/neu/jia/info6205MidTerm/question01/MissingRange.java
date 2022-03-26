package neu.jia.info6205MidTerm.question01;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {

    public List<String> missingRange(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int value = lower;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < value) {
                continue;
            }

            if (nums[i] == value) {
                value++;
                continue;
            }

            // finds gap
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            if (value != nums[i] - 1) {
                sb.append("->");
                sb.append(nums[i] - 1);
            }
            result.add(sb.toString());
            value = nums[i] + 1;
        }

        // postprocessing the result to display "->"
        if (value <= upper) {
            // finds gap
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            if (value != upper) {
                sb.append("->");
                sb.append(upper);
            }
            result.add(sb.toString());
        }
        return result;
    }
}
