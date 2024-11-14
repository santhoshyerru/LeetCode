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
    public TreeNode markParent(TreeNode root, Map<TreeNode, TreeNode> parent, int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode res = null;
        while(!q.isEmpty()){

            TreeNode cur = q.poll();
            if(cur.val==start) res = cur;
            if(cur.left!=null){
                q.offer(cur.left);
                parent.put(cur.left, cur);
            }
            if(cur.right!=null){
                q.offer(cur.right);
                parent.put(cur.right, cur);
            }
        }
        return res;
    }
    public int amountOfTime(TreeNode root, int start) {
         Map<TreeNode, TreeNode> parent = new HashMap<>();
       TreeNode st = markParent(root, parent,  start);

       Queue<TreeNode> q = new LinkedList<>();
       q.offer(st);
       HashSet<TreeNode> set = new HashSet<>();
       set.add(st);
       int burn = 0;
       while(!q.isEmpty()){

        int size = q.size();
        int fl = 0;
        for(int i=0;i<size;i++){
            TreeNode cur = q.poll();

            if(cur.left!=null && !set.contains(cur.left)){
                q.offer(cur.left);
                set.add(cur.left);
                fl=1;
            }
            if(cur.right!=null && !set.contains(cur.right)){
                q.offer(cur.right);
                set.add(cur.right);
                fl=1;
            }
            if(parent.get(cur)!=null && !set.contains(parent.get(cur))){
                q.offer(parent.get(cur));
                set.add(parent.get(cur));
                fl=1;
            }
        }
        if(fl==1)
        burn++;
       }
       return burn;
    }
}