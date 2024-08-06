class Solution {
    public int minimumPushes(String word) {
        int count[] = new int[26];
        for(int i=0;i<word.length();i++){
            count[word.charAt(i)-'a']+=1;
        }
         Integer[] countObj = Arrays.stream(count).boxed().toArray(Integer[]::new);
        Arrays.sort(countObj, (a, b) -> b - a); // Sorting in reverse order

        int res = 0;
        int distinct = 0;
        for (int i = 0; i < countObj.length; i++) {
            if (countObj[i] > 0) {
                res += countObj[i] * (distinct / 8 + 1);
                distinct++;
            }
        }
        return res;
    }
}