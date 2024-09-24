class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num: arr1){
            while(num>0 && !hs.contains(num)){
                hs.add(num);
                  num = num/10;
            }
        }
        int res = 0;
        for(int num: arr2){
            while(num>0 && !hs.contains(num)){
                num = num/10;
            }
            if(num>0) res = Math.max(res, Integer.toString(num).length() );
        }
        return res;
    }
}