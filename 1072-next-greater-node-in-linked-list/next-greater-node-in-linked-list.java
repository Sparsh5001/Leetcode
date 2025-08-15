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
    public int[] nextLargerNodes(ListNode head) {
        int length = 0;
        ListNode temp = head;
        ArrayList<Integer> List = new ArrayList<>();

        ListNode check;
        temp = head;
        while(temp!=null){
            check = temp;
            while(check!=null && check.val <= temp.val){
                check = check.next;
            }
            if(check!=null){
                List.add(check.val);
              
            }
            else{
                List.add(0);
            }
            length++;
            temp = temp.next;
        }
        int[] arr = new int[List.size()];
        for (int i = 0; i < List.size(); i++) {
             arr[i] = List.get(i);
        }

        return arr;
    }
}