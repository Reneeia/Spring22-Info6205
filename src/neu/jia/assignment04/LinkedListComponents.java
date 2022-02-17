package neu.jia.assignment04;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {

    public int numComponents(ListNode head, int[] nums) {

        //create a hashset to contain nums
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int numComponents = 0;

        //edge case the 0th ListNode,
        // if it is contains in the hashset
        if (numSet.contains(head.val)) {
            numComponents++;
        }

        //two pointers, one to head, one to head.next;
        ListNode prev = head;
        ListNode cur = head.next;

        //iterate the list, while the previous node val not in the hashset(just in case count duplicates)
        // and cur.val in the hash set ,numComponents++
        while (cur != null) {
            if (!numSet.contains(prev.val) && numSet.contains(cur.val)) {
                numComponents++;
            }
            prev = cur;
            cur = cur.next;
        }
        return numComponents;
    }
}
