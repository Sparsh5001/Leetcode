/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode start = head;
        ListNode prev = null;

        while(start!=null){
            ListNode end = start;
            for (int i = 1; i < k; i++) {
                if (end.next == null) {
                    return head;
                }
                end = end.next;
            }
            ListNode nex = end.next;
            ListNode newHead = rev(start,nex);
            if(prev==null){
                head=newHead;
            }else{
                prev.next=newHead;
            }

            prev = start;
            start=nex;
        }  
        return head;
    }

    public ListNode rev(ListNode start , ListNode nex) {
        ListNode head = nex;
        while(start!=nex){
            ListNode next = start.next;
            start.next = head;
            head = start;
            start = next;
        }
        return head;
    }
}