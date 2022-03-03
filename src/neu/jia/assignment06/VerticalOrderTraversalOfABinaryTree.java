package neu.jia.assignment06;

import neu.jia.assignment03.Node;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {


    //create a class to store treenode and its index x, y
    public class Node {
        TreeNode root;
        int x;
        int y;

        //constructor
        public Node(TreeNode root, int x, int y) {
            this.root = root;
            this.x = x;
            this.y = y;
        }
    }

    //comparator to compare the not, if y equals, compare value,
    // otherwise, compare y
    private static class CustomComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            if (n1.y == n2.y) {
                return n1.root.val - n2.root.val;
            }
            return n2.y - n1.y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //hashmap to store mode and its x(horizon)
        Map<Integer, List<Node>> map = new HashMap<>();

        //BFS
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0, 0));
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            minX = Math.min(minX, cur.x);
            maxX = Math.max(maxX, cur.x);

            map.putIfAbsent(cur.x, new ArrayList<>());
            map.get(cur.x).add(cur);

            if (cur.root.left != null) {
                queue.offer(new Node(cur.root.left, cur.x - 1, cur.y - 1));
            }
            if (cur.root.right != null) {
                queue.offer(new Node(cur.root.right, cur.x + 1, cur.y - 1));
            }
        }
        int index = 0;
        for (int i = minX; i <= maxX; i++) {
            Collections.sort(map.get(i), new CustomComparator());
            result.add(new ArrayList<>());
            for (Node node : map.get(i)) {
                result.get(index).add(node.root.val);
            }
            index++;
        }
        return result;
    }
}
