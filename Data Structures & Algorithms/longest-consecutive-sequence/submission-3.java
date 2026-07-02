class Solution {
    public int longestConsecutive(int[] nums) {
        // we know that we have to find the n - 1 and n + 1 of the current num
        // simple solution would be to sort the array, then count from the beginning and see if n + 1 is consecutive
        // since we cannot sort, we can use a set to track the n - 1 and n + 1 that are possible to exist

        Set<Integer> seen = new HashSet<>();
        int result = 0;

        for (int num : nums){
            seen.add(num);
        }

        for (int i = 0; i < nums.length; i++){
            int longest = 1;
            if (!seen.contains(nums[i] - 1)){
                while (seen.contains(nums[i] + longest)){
                    longest += 1;
                }
            }

            result = Math.max(longest, result);
        }

        return result;
    }
}