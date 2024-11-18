class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        int l = 0, sum = 0, n = code.length;
        if(k==0)
        return result;
        for(int r=0;r<n+Math.abs(k);r++){
            sum+=code[r%n];
            if(r-l+1>Math.abs(k)){
                sum-=code[l%n];
                l = (l+1)%n;
            }
            if(r-l+1==Math.abs(k)){
                if(k>0)
                result[(l-1+n)%n]= sum;
                else if(k<0)
                result[(r+1)%n] =sum;
            }
        }
        return result;
    }
}