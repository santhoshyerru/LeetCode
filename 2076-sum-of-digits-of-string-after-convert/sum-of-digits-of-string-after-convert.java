class Solution {
    public int sumOfDigits(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    public int getLucky(String s, int k) {
        StringBuilder intString = new StringBuilder(); // Use StringBuilder for efficient string concatenation
        // Convert each character to its corresponding number and append to intString
        for (char c : s.toCharArray()) {
            intString.append((c - 'a') + 1);
        }
      
        // Convert the StringBuilder content to a sum of digits directly
        int sum = 0;
        for (char c : intString.toString().toCharArray()) {
            sum += c - '0';
        }
        for(int i=1;i<k;i++){
            sum = sumOfDigits(sum);
        }
        return sum;
    }
}