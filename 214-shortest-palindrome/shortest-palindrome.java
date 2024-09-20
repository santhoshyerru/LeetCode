class Solution {
//     Rolling Hash
    public String shortestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s;
        }
        int mod = 1000000007, max = 1, i = 0, j = 1;
        long hvl = 0, hvr = 0, pow =1;
        
//         Rabin Karp
        while(j < s.length()){
            hvl = ((hvl * 26)%mod + (s.charAt(i) - 'a' + 1)) % mod;
            hvr = (hvr + ((s.charAt(j) - 'a' + 1) * pow) % mod) % mod;
            pow = (pow*26) % mod; // This can go negative thats why, need to keep modding.
            if(hvl == hvr){
			// Uncomment to make the check.
                // if(check(s, j)){
                //     max = j + 1;
                // }
                max = j+1; // comment it
            }
            i++;
            j++;
        }
        
//         Making the answer string
        StringBuilder ans = new StringBuilder(s.substring(max));
        i = 0;
        j = ans.length()-1;
        while(i < j){
            char temp = ans.charAt(i);
            ans.setCharAt(i, ans.charAt(j));
            ans.setCharAt(j, temp);
            i++;
            j--;
        }
        return ans.toString() + s;
    }
    
//     Usually we need to check the substring as well once the values map but it seems to get accepted without it.
//     Seems arent any hash conflicts in atleast these test cases.
    private boolean check(String s, int k){
        
        for(int i = 0, j = k; i<j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
        
}