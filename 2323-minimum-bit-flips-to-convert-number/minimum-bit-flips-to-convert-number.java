class Solution {
    public int minBitFlips(int start, int goal) {
        int xorValue = start^goal;
        int count = 0;
        while(xorValue>0){
            xorValue = xorValue&(xorValue-1);
            count++;
        }
        return count;
    }
}