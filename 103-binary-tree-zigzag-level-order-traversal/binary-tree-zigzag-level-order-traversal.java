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
    public void zighelp(TreeNode root, List<List<Integer>> ans){
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        boolean isLeft = true;
        while(!que.isEmpty()){
            int size = que.size();
            
            ArrayList<Integer> row = new ArrayList<Integer>(Collections.nCopies(size, 0));
            for(int i=0;i<size;i++){
                TreeNode node = que.poll();
                int ind = isLeft? i: size-1-i;
                row.set(ind, node.val);
                if(node.left!=null)
                que.offer(node.left);
                if(node.right!=null)
                que.offer(node.right);
            }
            isLeft = !isLeft;
            ans.add(new ArrayList<>(row));
        }
      
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     
        List<List<Integer>> ans = new ArrayList<>();
           if(root==null){
            return ans;
        }
        zighelp(root, ans);
        return ans;
    }
}