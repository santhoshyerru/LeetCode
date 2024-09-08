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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while(cur!=null){
            cur = cur.next;
            len++;
        }

        int base_length = len/k; int remainder = len%k;
        cur = head;
        ListNode res[] = new ListNode[k];
        for(int i = 0;i<k;i++){
            res[i] = cur;
            int rem = remainder>0 ? 1: 0;
            for(int j = 0; j<(base_length-1 + rem); j++){
                if(cur==null) break;
                cur = cur.next;
            }
            remainder = remainder - (remainder>0 ? 1: 0);
            if(cur!=null) {
                ListNode temp = cur.next;
                cur.next = null;
                cur = temp;
            }
        }
        return res;
    }
}