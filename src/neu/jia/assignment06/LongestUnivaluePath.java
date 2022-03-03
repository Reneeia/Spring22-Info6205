package neu.jia.assignment06;

public class LongestUnivaluePath {

    int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return result;
    }

    //return the max path edge number, including the root
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        //if root.left is not null and its val equals root.val ++
        //otherwise, left = 0
        if (root.left != null && root.val == root.left.val) {
            left++;
        } else {
            left = 0;
        }
        //if root.right is not null and its val equals root.val ++
        //otherwise, right = 0
        if (root.right != null && root.val == root.right.val) {
            right++;
        } else {
            right = 0;
        }

        //result is the maximum left + right, either left or right
        result = Math.max(result, left + right);
        return Math.max(left, right);
    }
}
