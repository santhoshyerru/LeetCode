class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        int n = heights.length;
        for(int i=0;i<names.length;i++){
                hm.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
   for (int i = 0; i < n / 2; ++i) {
            int temp = heights[i];
            heights[i] = heights[n - 1 - i];
            heights[n - 1 - i] = temp;
        }
        for(int i =0;i<heights.length;i++){
            names[i] = hm.get(heights[i]);
        }
        return names;
    }
}