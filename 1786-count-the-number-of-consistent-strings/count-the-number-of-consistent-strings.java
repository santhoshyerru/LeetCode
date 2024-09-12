class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> hs = new HashSet<>();
        for(char c: allowed.toCharArray()){
            hs.add(c);
        }
        int flag=0;
        int count = 0;
        for(String str: words){
            flag = 0;
            for(char c: str.toCharArray()){
                if(!hs.contains(c)){
                    flag = 1;
                    break;
                }
            }
            if(flag==0){
                count++;
            }
        }
        return count;
    }
}