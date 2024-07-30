class Solution {
    public int minimumDeletions(String s) {
        int a_count_right = 0;
        for(char c: s.toCharArray()){
            if(c=='a'){
                a_count_right +=1;
            }
        }

        int b_count = 0;
        int mini = Integer.MAX_VALUE;
        for(char c: s.toCharArray()){
            if(c=='a'){
                a_count_right--;
            }
            mini = Math.min(a_count_right+b_count, mini);
            if(c=='b'){
                b_count++;
            }
        }
        return mini;
    }
}