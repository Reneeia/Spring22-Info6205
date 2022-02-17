package neu.jia.assignment04;

import java.util.ArrayList;
import java.util.List;

public class LinkedListRandomNode {

    ListNode head;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int winner = head.val;
        ListNode cur = head;
        for (int i = 1; cur.next != null; i++) {
            cur = cur.next;
            if (getRandomNum(i + 1) == 0) {
                winner = cur.val;
            }
        }
        return winner;
    }

    //helper method to get a random number from [0,n)
    private int getRandomNum(int n) {
        return (int) (Math.random() * n);
    }
}
