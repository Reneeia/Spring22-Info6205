package neu.jia.assignment06;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    //helper method to convert tree into a stringbuilder,
    //null->"#", each node separate by ","
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            sb.append(",");
            //if not null, store the value in the stringbuilder
            //do the same in the left/right child
        } else {
            sb.append(root.val);
            sb.append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //create a linked list to store the date,
        // why linked list, because we have to use moveFirst method
        LinkedList<String> stringList = new LinkedList(Arrays.asList(data.split(",")));
        return deserialize(stringList);
    }

    //helper method to convert string(list) to tree
    private TreeNode deserialize(LinkedList<String> stringList) {
        //linked list has a method removeFirst
        String first = stringList.removeFirst();
        if (first.equals("#")) {
            return null;
        }
        //if not "#"/null, create a treenode to store the value
        TreeNode root = new TreeNode(Integer.valueOf(first));
        //do the same to left/right child
        root.left = deserialize(stringList);
        root.right = deserialize(stringList);
        return root;
    }
}
