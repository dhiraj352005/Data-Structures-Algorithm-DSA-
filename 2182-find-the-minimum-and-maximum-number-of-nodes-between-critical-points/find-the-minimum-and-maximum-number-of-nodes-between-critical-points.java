class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1,-1};
        int minDistance = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;
        int firstCritical = 0;
        int prevCritical = 0;

        while(curr.next != null) {
            if((curr.val < prev.val && curr.val < curr.next.val) ||
               (curr.val > prev.val && curr.val > curr.next.val)) {

                if(prevCritical == 0) {
                    firstCritical = index;
                    prevCritical = index;
                } else {
                    minDistance = Math.min(minDistance,index-prevCritical);
                    prevCritical = index;
                }
            }

            index++;
            prev = curr;
            curr = curr.next;
        }

        if(minDistance != Integer.MAX_VALUE) {
            int maxDistance = prevCritical-firstCritical;
            result[0] = minDistance;
            result[1] = maxDistance;
        }

        return result;
    }
}