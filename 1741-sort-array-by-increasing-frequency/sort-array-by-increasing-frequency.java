class Solution {
    public int[] frequencySort(int[] nums) {
        // Create a HashMap to store frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a list of map entries
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list using a custom Comparator
        Collections.sort(list, (a, b) -> {
            // First, compare by frequency (value) in increasing order
            int freqCompare = a.getValue().compareTo(b.getValue());
            if (freqCompare != 0) {
                return freqCompare;
            }
            // If frequencies are the same, compare numbers (key) in decreasing order
            return b.getKey().compareTo(a.getKey());
        });

        // Create result array
        int[] result = new int[nums.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            int num = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                result[index++] = num;
            }
        }

        return result;
    }
}