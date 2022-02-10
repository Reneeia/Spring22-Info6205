package neu.jia.assignment03;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        //creat a hash map to store the original list's value and created new list's value first
        Map<Node, Node> nodeValueMap = new HashMap<>();

        //iterate the list from head to store the value only in hashmap
        Node cur = head;
        while (cur != null) {
            nodeValueMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        //iterate again for the next and random nod
        cur = head;
        while (cur != null) {
            nodeValueMap.get(cur).next = nodeValueMap.get(cur.next);
            nodeValueMap.get(cur).random = nodeValueMap.get(cur.random);
            cur = cur.next;
        }
        //return the head from the hashmap
        return nodeValueMap.get(head);
    }
}
