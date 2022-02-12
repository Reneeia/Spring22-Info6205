package neu.jia.assignment03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //create a array list to store each list in lists
        List<Integer> allNodes = new ArrayList<Integer>();
        for (ListNode node : lists) {
            while (node != null) {
                allNodes.add(node.val);
                node = node.next;
            }
        }

        //sort the array list
        Collections.sort(allNodes);

        //prev node to store the head
        ListNode prev = new ListNode(0);
        //a pointer from prev
        ListNode cur = prev;

        for (Integer nodeVal : allNodes) {
            ListNode temp = new ListNode(nodeVal);
            cur.next = temp;
            cur = cur.next;
        }
        return prev.next;
    }
}
