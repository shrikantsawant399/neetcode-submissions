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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode prev = null;
        int listLength = 0;

        while(current != null){
            ++listLength;
            current = current.next;
        }

        if(listLength - n == 0) {
            head = head.next;
            return head;
        }    

        current = head;
        for(int i = 0; i < listLength - n; i++){
            prev = current;
            current = current.next;
        }

        prev.next = current.next;

        return head;
    }
}
