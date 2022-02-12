package neu.jia.assignment03;

public class InsertIntoSortedCircularLinkedList {

    public Node insert(Node head, int insertVal) {
       //edge case: if head equals null, insert the node point itself
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        //find max node
        Node max = head;
        while (max.next != head && max.val <= max.next.val) {
            max = max.next;
        }

        // at this point prev = max (current = min)
        Node prev = max;
        Node current = prev.next;

        // edge case 1: if insertVal < min & edge case 2: if insertVal > max
        if (insertVal <= current.val || insertVal >= prev.val) {
            // insert it to  prev --> insert node --> current
            Node newNode = new Node(insertVal);
            prev.next = newNode;
            newNode.next = current;
            return head;
        }

        while (current.val < insertVal) {
            current = current.next;
            prev = prev.next;
        }

        // insert it to  prev --> insert node --> current
        Node newNode = new Node(insertVal);
        prev.next = newNode;
        newNode.next = current;

        return head;
    }
}
