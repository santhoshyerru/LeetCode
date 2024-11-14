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
class Pair{
    int ind;
    TreeNode node;
     Pair(int _ind, TreeNode _node){
        ind = _ind;
        node = _node;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().ind;
            int first=0, last=0;
            for(int i=0;i<size;i++){
                Pair pair = q.poll();
                int ind = pair.ind-mmin;
                TreeNode node = pair.node;
                if(i==0) first = ind;
                if(i==size-1) last = ind;
                if(node.left!=null){
                    q.offer(new Pair(2*ind+1, node.left));
                }
                if(node.right!=null){
                    q.offer(new Pair(2*ind+2, node.right));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}