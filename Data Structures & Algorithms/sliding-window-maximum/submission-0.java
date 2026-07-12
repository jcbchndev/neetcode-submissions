class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> output = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();

        int l = 0;
        int r = 0;

        while (r < nums.length){
            while(!q.isEmpty() && nums[q.peekLast()] < nums[r]){
                q.pollLast();
            }
            q.offer(r);

            if (l > q.peek()){
                q.pop();
            }

            if (r + 1 >= k){
                output.add(nums[q.peek()]);
                l++;
            }
            r++;
        }
        return output.stream().mapToInt(Integer::intValue).toArray();     
    }
}
