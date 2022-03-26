package neu.jia.info6205MidTerm.question03;

import java.util.HashMap;
import java.util.Map;

public class ConstructPreOrderInOrderTree {

    public TreeNode ConstructPreOrderInOrderTree(int[] inOrder, int[] preOrder) {
        if (inOrder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inOrderIndexMap = getIndexMapForInOrder(inOrder);
        return dfs(0, inOrder.length - 1, preOrder, 0, preOrder.length - 1, inOrderIndexMap);
    }

    //put inorder in a hash map, and helper method to get the index of inorder
    private Map<Integer, Integer> getIndexMapForInOrder(int[] in) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int idx = 0; idx < in.length; idx++) {
            indexMap.put(in[idx], idx);
        }
        return indexMap;
    }

    //dfs and return the construct tree
    private TreeNode dfs(int inStart, int inEnd, int[] preOrder, int preStart, int preEnd, Map<Integer, Integer> inMap) {
        //base
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        int curHeadVal = preOrder[preStart];
        TreeNode curHead = new TreeNode(curHeadVal);
        int curHeadInOrderIdx = inMap.get(curHeadVal);
        int leftSubTreeLen = curHeadInOrderIdx - inStart;

        curHead.left = dfs(inStart, inStart + leftSubTreeLen - 1, preOrder, preStart + 1, preStart + leftSubTreeLen, inMap);
        curHead.right = dfs(curHeadInOrderIdx + 1, inEnd, preOrder, preStart + leftSubTreeLen + 1, preEnd, inMap);

        return curHead;
    }
}
    
    
    
    
    
    
    
