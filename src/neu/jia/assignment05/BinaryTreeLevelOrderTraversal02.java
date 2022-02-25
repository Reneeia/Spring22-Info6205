package neu.jia.assignment05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal02 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        //edge case, root null
        if (root == null) {
            return result;
        }

        //create a queue to store the root
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //check level by level,
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            //store the size of the level
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                //poll node from queue, add to list
                TreeNode node = queue.poll();
                level.add(node.val);

                //check if there is left or right node with current node
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //arraylist method, .add(index,level)
            //each time add to the first place
            result.add(0, level);
        }
        return result;
    }
}
