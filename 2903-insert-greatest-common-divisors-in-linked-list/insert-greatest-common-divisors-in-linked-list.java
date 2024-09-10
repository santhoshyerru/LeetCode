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
    public int gcd(int n1, int n2){
        while(n2>0){
            int temp = n2;
            n2 = n1%n2;
            n1= temp;
        }
        return n1;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while(cur.next!=null){
            int n1 = cur.val, n2 = cur.next.val;
            ListNode temp = new ListNode(gcd(n1, n2), cur.next);
            cur.next = temp;
            cur = cur.next.next;
        }
        return head;
    }
}