class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        for(String log: logs){
            if(log.equals("../")){
                if (ans > 0) {
                    ans--;
                }
            }
            else if(log.equals("./")){
                // Do nothing
            }
            else{
                ans++;
            }
        }
        return ans;
    }
}