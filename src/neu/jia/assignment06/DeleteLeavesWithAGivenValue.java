package neu.jia.assignment06;

public class DeleteLeavesWithAGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        //if root is leave node and its val equals target, return null(delete)
        //otherwise, return the root
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}
