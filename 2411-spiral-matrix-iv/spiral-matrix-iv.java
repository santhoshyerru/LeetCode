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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];

        // Initialize the matrix with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = -1;
            }
        }

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        ListNode cur = head;

        // Traverse the matrix in a spiral order
        while (cur != null && top <= bottom && left <= right) {
            // Traverse left to right
            for (int i = left; i <= right && cur != null; i++) {
                res[top][i] = cur.val;
                cur = cur.next;
            }
            top++;

            // Traverse top to bottom
            for (int i = top; i <= bottom && cur != null; i++) {
                res[i][right] = cur.val;
                cur = cur.next;
            }
            right--;

            // Traverse right to left
            if (top <= bottom) {  // Ensure top hasn't crossed bottom
                for (int i = right; i >= left && cur != null; i--) {
                    res[bottom][i] = cur.val;
                    cur = cur.next;
                }
                bottom--;
            }

            // Traverse bottom to top
            if (left <= right) {  // Ensure left hasn't crossed right
                for (int i = bottom; i >= top && cur != null; i--) {
                    res[i][left] = cur.val;
                    cur = cur.next;
                }
                left++;
            }
        }

        return res;
    }
}
