class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // simple soltion would be to - iterate nums over 3 times until we find i,j,k = 0
        // -4 -1 -1 0 1 2
        

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++){

            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int target = nums[i];
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k){
                if (nums[k] + nums[j] == -target){
                    result.add(new ArrayList<>(List.of(
                        nums[i],
                        nums[j],
                        nums[k]
                    )));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                    while (j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                    continue;
                }

                if (nums[k] + nums[j] > -target){
                    k--;
                    continue;
                }
                else {
                    j++;
                }
            }
        }

        return result;
    }
}
