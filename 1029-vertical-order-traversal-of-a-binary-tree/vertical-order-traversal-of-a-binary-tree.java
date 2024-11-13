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
class Tuple{
    int x;
    int y;
    TreeNode node;
    public Tuple(int _x, int _y, TreeNode _node){
        x = _x;
        y = _y;
        node = _node;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, 0, root));
        while(!q.isEmpty()){
            int size = q.size();
            Tuple tuple = q.poll();
            int x = tuple.x;
            int y = tuple.y;
            TreeNode node = tuple.node;
            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            if(node.left!=null){
                q.offer(new Tuple( x-1, y+1, node.left));
            }
            if(node.right!=null){
                q.offer(new Tuple( x+1, y+1, node.right));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> ps: ys.values()){
                while(!ps.isEmpty()){
                list.add(ps.poll());
                }
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}