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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right){
            return head;
        }

        ListNode prev = null;
        ListNode start = head;
        int i = 1;
        while(i < left){
            prev = start;
            start = start.next;
            i++;
        }

        ListNode end = start;
        while(i<right){
            end=end.next;
            i++;
        }
        ListNode nex = end.next;
        ListNode newHead = rev(start,nex);

        if(prev==null){
            head = newHead;
        }else{
            prev.next = newHead;
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