package neu.jia.assignment05;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    //create a class TreeNodeWithIndex to store every TreeNode with its index
    private static class TreeNodeWithIndex {
        TreeNode node;
        int index;

        //constructor 
        public TreeNodeWithIndex(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        int result = 0;
        if (root == null) {
            return result;
        }

        //follow the steps in level order, create a queue and put treenode and its index the queue
        Queue<TreeNodeWithIndex> queue = new LinkedList<>();
        queue.offer(new TreeNodeWithIndex(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int leftMost = Integer.MAX_VALUE;
            int rightMost = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNodeWithIndex nodeIndexPair = queue.poll();

                if (nodeIndexPair.node.left != null) {
                    int leftIndex = nodeIndexPair.index * 2;
                    queue.offer(new TreeNodeWithIndex(nodeIndexPair.node.left, leftIndex));
                }
                if (nodeIndexPair.node.right != null) {
                    int rightIndex = nodeIndexPair.index * 2 + 1;
                    queue.offer(new TreeNodeWithIndex(nodeIndexPair.node.right, rightIndex));
                }
                if (i == 0) {
                    leftMost = nodeIndexPair.index;
                }
                if (i == size - 1) {
                    rightMost = nodeIndexPair.index;
                }
            }
            int curWidth = rightMost - leftMost + 1;
            result = Math.max(result, curWidth);
        }
        return result;
    }
}
