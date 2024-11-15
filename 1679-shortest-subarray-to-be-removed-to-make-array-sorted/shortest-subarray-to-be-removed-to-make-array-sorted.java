class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int l = 0, r = arr.length-1;
        int N = arr.length;
        //Remove Prefix;
        while(r>0 && arr[r-1]<=arr[r]){
            r--;
        }

        int minL = r;

        while(l<r){
            //expand invalid window
            while(r<N && arr[l]>arr[r]){
                r++;
            }
            minL = Math.min(minL, r-l-1);
            if(arr[l]>arr[l+1]){
                break;
            }
            l++;
        }
        return minL;
    }
}