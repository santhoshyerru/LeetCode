class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long totalChalkNeeded = 0;
        for(int cha: chalk){
            totalChalkNeeded+=cha;
        }
        int remainingChalk = (int)(k%totalChalkNeeded);
        for(int i=0;i<chalk.length;i++){
            if(remainingChalk<chalk[i]){
                return i;
            }
            remainingChalk -=chalk[i];
        }
        return 0;
    }
}