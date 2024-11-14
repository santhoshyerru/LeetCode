/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(TreeNode root, Map<TreeNode, TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            if(current.left!=null){
                q.offer(current.left);
                map.put(current.left, current);
            }
            if(current.right!=null){
                q.offer(current.right);
                map.put(current.right, current);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode, TreeNode> map = new HashMap<>();
        markParents(root, map);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(target);
        int distance = 0;
        visited.put(target, true);
        List<Integer> ans = new ArrayList<>();
        while(!que.isEmpty()){
            int size = que.size();
            if(k==distance)
            break;
            distance++;
            for(int i=0;i<size;i++){
                TreeNode cur = que.poll();
                if(cur.left!=null && !visited.containsKey(cur.left)){
                    que.offer(cur.left);
                    visited.put(cur.left, true);
                }
                if(cur.right!=null && !visited.containsKey(cur.right)){
                    que.offer(cur.right);
                    visited.put(cur.right, true);
                }
                if(map.get(cur)!=null && !visited.containsKey(map.get(cur))){
                    que.offer(map.get(cur));
                    visited.put(map.get(cur), true);
                }
              
            }

        }
                        while(!que.isEmpty()){
                    ans.add(que.poll().val);
                }
        return ans;
        
    }
}