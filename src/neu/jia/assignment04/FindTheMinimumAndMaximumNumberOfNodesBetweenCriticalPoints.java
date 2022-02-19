package neu.jia.assignment04;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        //three pointers, first critical point, previous critical point and curCp
        int firstCp = -1;
        int prevCp = -1;
        int curIndex = 1;

        ListNode prev = head;
        ListNode cur = head.next;

        //
        while (cur != null && cur.next != null) {
            if ((cur.val > cur.next.val && cur.val > prev.val) || (cur.val < cur.next.val && cur.val < prev.val)) {
                if (firstCp == -1) {
                    firstCp = curIndex;
                } else {
                    //minimum distance equals minimum of curIndex - prevCp
                    minDistance = Math.min(minDistance, curIndex - prevCp);
                    //maximum distance equals curIndex - firstCp
                    maxDistance = Math.max(maxDistance, curIndex - firstCp);
                }
                prevCp = curIndex;
            }
            curIndex++;
            prev = cur;
            cur = cur.next;
        }
        //edge case, is there is no critical point
        if (maxDistance == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{minDistance, maxDistance};
    }
}
