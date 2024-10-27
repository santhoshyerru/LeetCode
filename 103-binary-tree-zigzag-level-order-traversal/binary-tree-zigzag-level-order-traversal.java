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
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(size,0));
            
            for(int i=0;i<size;i++){
                
                TreeNode it = queue.poll();
                int index = leftToRight? i: size-1-i;
                row.set(index, it.val);
                if(it.left!=null){
                    queue.offer(it.left);
                }
                if(it.right!=null){
                    queue.offer(it.right);
                }
                
            }
            leftToRight = !leftToRight;
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