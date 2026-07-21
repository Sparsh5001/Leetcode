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


    public ListNode rev(ListNode start){
        ListNode temp = start;
        ListNode temp_fast = start;
        ListNode tail = start;

        if(start==null || start.next==null){
            return start;
        }
        temp = start.next;
        temp_fast = start.next.next;

        while(temp!=null){
            temp.next=start;
            start = temp;
            temp = temp_fast; 
            if(temp==null){
                break;
            }
            temp_fast = temp_fast.next;
        }
        tail.next = null;
        return start;
    }

}