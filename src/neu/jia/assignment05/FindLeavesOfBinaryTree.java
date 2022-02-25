package neu.jia.assignment05;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        height(root, result);
        root = null;
        return result;
    }

    //helper method to get the height/level of the tree
    private int height(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return -1;
        }
        int level = Math.max(height(root.left, result), height(root.right, result)) + 1;

        if (result.size() < level + 1) {
            result.add(new ArrayList());
        }
        result.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
    }
}
