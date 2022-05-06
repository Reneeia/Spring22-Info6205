package neu.jia.info6205Final.question04;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //edge case, if root is null or root == p, q, return root
        if (root == null || root == q || root == p) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //if both left and right are not null, return root as LCA
        if (left != null && right != null) {
            return root;
        }

        //return left or right when not null
        if (left != null) {
            return left;
        }
        return right;
    }
}
