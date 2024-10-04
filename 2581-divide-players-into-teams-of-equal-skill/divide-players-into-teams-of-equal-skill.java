class Solution {
    public long dividePlayers(int[] skill) {
        HashMap<Integer, Integer> hm  = new HashMap<>();
        int total = 0;
        for(int i: skill){
            hm.put(i, hm.getOrDefault(i, 0)+1);
            total += i;
        }
        long sum = 0;
        int target = (2*total)/skill.length;
        for(int s: skill){
            if(hm.get(s)==0)
                continue;
            if(hm.containsKey(target-s) && hm.containsKey(s) && hm.get(s)>0 && hm.get(target-s)>0){
                sum += s * (target-s);
                hm.put(target-s, hm.get(target-s)-1);
                hm.put(s, hm.get(s)-1);
            }else{
                return -1;
            }
        }
        return sum;

    }
}