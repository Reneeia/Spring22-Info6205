package neu.jia.assignment05;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        findLevelLargest(root, result, 0);
        return result;
    }

    private void findLevelLargest(TreeNode root, List<Integer> result, int level) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(root.val);
        } else {
            result.set(level, Math.max(result.get(level), root.val));
        }
        findLevelLargest(root.left, result, level + 1);
        findLevelLargest(root.right, result, level + 1);
    }
}
