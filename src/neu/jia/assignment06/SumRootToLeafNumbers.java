package neu.jia.assignment06;

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        int[] result = new int[1];
        if (root == null) {
            return result[0];
        }
        dfs(root, result, root.val);
        return result[0];


    }

    private void dfs(TreeNode root, int[] result, int previousSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result[0] = result[0] + previousSum;
        }

        if (root.left != null) {
            int sum = previousSum * 10 + root.left.val;
            dfs(root.left, result, sum);
        }

        if (root.right != null) {
            int sum = previousSum * 10 + root.right.val;
            dfs(root.right, result, sum);
        }
    }
}
