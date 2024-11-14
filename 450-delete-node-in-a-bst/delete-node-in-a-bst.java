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
   public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(root.val == key){
            return helper(root);
        }

        TreeNode dummy = root;
        while(dummy!=null){
            if(key<dummy.val){
                if(dummy.left!=null && dummy.left.val == key){
                    dummy.left = helper(dummy.left);
                    break;
                }
                else{
                    dummy = dummy.left;
                }
            }
            else{
                 if(dummy.right!=null && dummy.right.val == key){
                    dummy.right = helper(dummy.right);
                    break;
                }
                else{
                    dummy = dummy.right;
                }
            }
        }
        return root;
    }
    public TreeNode helper(TreeNode node){
        if(node.left ==null)
        return node.right;
        if(node.right==null)
        return node.left;
        TreeNode lastRight = findLastRight(node.left);
        lastRight.right = node.right;
        return node.left;

    }
    public TreeNode findLastRight(TreeNode node){
        while(node.right!=null){
            node = node.right;
        }
        return node;
    }
}