class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            char oper = expression.charAt(i);
            if(oper =='+'|| oper=='-' || oper=='*'){
                List<Integer> nums1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> nums2 = diffWaysToCompute(expression.substring(i+1));
                for(int j: nums1){
                    for(int k: nums2){
                        if(expression.charAt(i)=='+')
                        res.add(j+k);
                        else if(expression.charAt(i)=='-')
                        res.add(j-k);
                        else if(expression.charAt(i)=='*')
                        res.add(j*k);
                    }
                }
            }
        }
        if(res.isEmpty()){
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}