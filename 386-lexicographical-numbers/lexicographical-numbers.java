class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1;
        while(res.size()<n){
            res.add(cur);
            if(cur*10<=n){
                cur = cur*10;
            }
            else{
                while(cur==n || cur%10==9){
                    cur = cur/10;
                }
                cur = cur+1;
            }
        }
        return res;
    }
}