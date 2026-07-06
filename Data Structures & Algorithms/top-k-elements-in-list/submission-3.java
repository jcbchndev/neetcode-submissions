class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] output = new int[k];

        for (int i = 0; i < nums.length; i++){
            if (freq.containsKey(nums[i])){
                int val = freq.get(nums[i]);
                freq.put(nums[i], val + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key: freq.keySet()){ // the key of the freq array is the num, val is the freq count
            int val = freq.get(key);
            if (bucket[val] == null){
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
            
        }

        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--){
            if (bucket[i] != null){
                for (int num : bucket[i]){
                    output[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return output;
    }
}
