class Solution {
    public void bfs(int[][] isConnected, boolean[] visited, int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0;i<isConnected.length;i++){
                if(isConnected[cur][i]==1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int cnt=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
            bfs(isConnected, visited, i);
            cnt++;
            }
        }
        return cnt;
    }   
}