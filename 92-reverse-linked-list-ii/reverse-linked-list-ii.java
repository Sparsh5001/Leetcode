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
        if(head == null || head.next == null){
            return head;
        }
        if(left == right){
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

        ListNode nex = start;
        ListNode end = prev;
        while(i<=right){
            end = nex;
            nex = nex.next;
            i++;
        }
        end.next = null;

        start = rev(start);

        if(prev!=null){
            prev.next = start;
        }else{
            head = start;
        }
        
        while(start.next!=null){
            start = start.next;
        }
        start.next = nex;
        return head;
    }


    public ListNode rev(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current!=null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}