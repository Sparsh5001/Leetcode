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
    public ListNode rotateRight(ListNode head, int k) {
        int length = len(head);
        if(length==0){
            return head;
        }
        int rotate = k%length;

        ListNode ahead = head;
        for(int i = 0 ; i < rotate ; i++){
            ahead = ahead.next;
        }
        ListNode behind = head;
        while(ahead.next!=null){
            ahead=ahead.next;
            behind= behind.next;
        }

        ahead.next = head;
        head = behind.next;
        behind.next = null;
        return head;
    }




    public int len(ListNode temp){
        int i = 0;
        while(temp!=null){
            i++;
            temp = temp.next;
        }
        return i;
    }
}