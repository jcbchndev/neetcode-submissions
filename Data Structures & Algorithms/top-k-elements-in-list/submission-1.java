class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> freq = new PriorityQueue<>(
            (a,b) -> counts.get(b) - counts.get(a)
        );

        for (int num : counts.keySet()){
            freq.offer(num);
        }
        
        for (int j = 0; j < k; j++) {
            res.add(freq.poll());
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
