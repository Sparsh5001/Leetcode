/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int length;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                length = CheckLength( slow);
                ListNode tempH = head;
                ListNode temp = head;
                for(int i = 0 ; i<length ; i++){
                    temp = temp.next;
                }
                while(temp != tempH){
                    temp = temp.next;
                    tempH = tempH.next;
                }
                return temp;
            }
        }
        return null;
    }

    public int CheckLength( ListNode slow){
            int count = 1;
            ListNode current = slow.next;
            while(slow!=current){
                current = current.next;
                count ++;
            }
            return count;
    }
}