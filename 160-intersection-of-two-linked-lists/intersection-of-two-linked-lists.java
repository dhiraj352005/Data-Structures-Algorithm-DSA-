/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA;
        ListNode B=headB;
        int lenA=0;
        int lenB=0;
        while(A != null){
            lenA++;
            A=A.next;
        }
         while(B != null){
            lenB++;
            B=B.next;
        }

        A=headA;
        B=headB;
        int diff = Math.abs(lenA-lenB);

        if(lenA > lenB){
           for(int i=0; i<diff; i++){
            A=A.next;
           }
        }else{
            for(int i=0; i<diff; i++){
              B=B.next;
            }
        }
        while(A != null || B != null){
            if(A == B){
                return A;
            }
            A=A.next;
            B=B.next;
        }

        return null;

    }
}

