package neu.jia.assignment06;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNode {
    public int countNodes(TreeNode root) {
        //edge case
        if (root == null) {
            return 0;
        }
        //counter
        int count = 0;
        //BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                count++;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return count;
    }
}
