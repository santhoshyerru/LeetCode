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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> toBeDel = new HashSet<>();
        for(var num : nums)toBeDel.add(num);

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode cur = head;
        while(cur!=null){
            if(toBeDel.contains(cur.val)){
                prev.next = cur.next;
            }
            else{
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}