package neu.jia.assignment03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {

        //create a arraylist to store the linked list
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        //create a stack: last in first out:  push(add) pop(take out) peek(see the first value)
        Stack<Integer> stack = new Stack<>();

        //create a result array, size equals the list.size()
        int[] result = new int[list.size()];

        //iterate the list
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                result[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return result;
    }
}
