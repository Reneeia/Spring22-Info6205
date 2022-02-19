package neu.jia.assignment04;

import java.util.ArrayList;
import java.util.List;

/*
solution steps:
1.break list by 1,2,3,4,....length group
2.reverse the even length part
3.reconnect the whole list
 */

public class ReverseNodesInEvenLengthGroups {

    public ListNode reverseEvenLengthGroups(ListNode head) {
        //arraylist to store each head
        List<ListNode> heads = new ArrayList<>();
        //arraylist to store each length
        List<Integer> lengths = new ArrayList<>();

        int length = 1;
        ListNode cur = head;
        ListNode next;

        //iterate list and count number of nodes
        while (cur != null) {
            heads.add(cur);
            int count = 1;
            for (int i = 0; i < length - 1; i++) {
                if (cur.next == null) {
                    break;
                }
                cur = cur.next;
                count++;
            }
            lengths.add(count);
            if (cur.next == null) {
                break;
            }
            next = cur.next;
            cur.next = null;
            cur = next;
            length++;
        }

        //reverse even length group
        for (int i = 0; i < heads.size(); i++) {
            if (lengths.get(i) % 2 == 0) {
                ListNode reversedList = reverseList(heads.get(i));
                heads.set(i, reversedList);
            }
        }

        for (int i = 0; i < heads.size() - 1; i++) {
            ListNode prev = heads.get(i);
            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = heads.get(i + 1);
        }
        return heads.get(0);
    }

    //helper method to reverse linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
