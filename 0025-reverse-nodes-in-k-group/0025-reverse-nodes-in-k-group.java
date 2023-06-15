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
    
    public void reverse(ListNode start, ListNode end){
        end.next = null;
        ListNode pre = null;
        
        while(start != null){
            ListNode next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode curr = head, prev = null;
        int i = 0;
        while(curr != null){
            
            ListNode start = curr;
            ListNode end = null;
            
            while(curr != null && i < k){
                end = curr;
                curr = curr.next;
                i++;
            }
            
            if(i == k){
                
                if(start == head) head = end;
                
                reverse(start, end);
                
                start.next = curr;
                if(prev != null) prev.next = end;
                
                prev = start;
            }
            i = 0;
        }
        
        return head;
    }
}
















