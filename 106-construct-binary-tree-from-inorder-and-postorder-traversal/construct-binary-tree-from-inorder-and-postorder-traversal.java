/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildPostTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> map){
        if(inStart>inEnd || postStart>postEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(postorder[postEnd]);
        int numsLeft = inRoot-inStart;
        root.left = buildPostTree(inorder, postorder, inStart, inRoot-1, postStart, postStart+numsLeft-1, map);
        root.right = buildPostTree(inorder, postorder, inRoot+1, inEnd, postStart+numsLeft, postEnd-1, map);
        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return buildPostTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, map);
    }
}