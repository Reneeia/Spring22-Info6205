package neu.jia.assignment04;

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] result = new ListNode[k];

        //count is the number of nodes
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        //length is the basic length of lists
        //distribute is the rest nodes need to be added to lists
        int length = count / k;
        int distribute = count % k;

        ListNode newHead = head;
        for (int i = 0; i < k; i++) {
            cur = newHead;
            result[i] = cur;

            int currentLen = length;
            if (distribute > 0) {
                currentLen++;
            }
            for (int j = 0; j < currentLen - 1; j++) {
                cur = cur.next;
            }
            if (cur == null) {
                return result;
            }
            newHead = cur.next;
            cur.next = null;
            distribute--;
        }

        return result;
    }
}
