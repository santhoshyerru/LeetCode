class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int sum = 0;
        int maxi = 0;
        for(int k: quantities){
            sum += k;
            maxi = Math.max(maxi, k);
        }
        int high = maxi;
        int low = sum/n;
        if(low==0) low = 1;
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(n, quantities, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean isPossible(int n, int[] quantities, int mid){
        int stores = 0;
        for(int k: quantities){
            stores += k/mid;
            if(k%mid>0) stores++;
            if(stores>n) return false;
        }
        return true;
    }
}