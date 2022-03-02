package neu.jia.assignment06;

public class PathSum03 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    //helper method to dfs,left and right
    private int dfs(TreeNode root, int targetSum) {
        //base case, termination condition
        if (root == null) {
            return 0;
        }
        //every time - root.val
        targetSum = targetSum - root.val;
        if (targetSum == 0) {
            //if targetSum == 0 means there is a path
            //1+
            return 1 + dfs(root.left, targetSum) + dfs(root.right, targetSum);
        }
        //if targetSum != 0
        //0+
        return dfs(root.left, targetSum) + dfs(root.right, targetSum);
    }
}
