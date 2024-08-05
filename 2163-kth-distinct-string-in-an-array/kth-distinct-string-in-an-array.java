class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }
        int distinct = 0;
        for(String i: arr){
            if(hm.get(i)==1){
                distinct++;
            }
            if(distinct==k){
                return i;
            }
        }
        return "";
    }
}