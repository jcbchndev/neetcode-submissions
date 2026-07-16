class Solution {
    public int findMin(int[] nums) {
        // left segment max = times rotated - 1
        // right segment min = times rotated

        int l = 0;
        int r = nums.length - 1;

        if (nums[l] < nums[r]){
            return nums[l];
        }

        while (l < r){
            int mid = (l + r) / 2;

            // break detection
            if (nums[mid] < nums[0]){
                r = mid;
            }
            else if (nums[mid] >= nums[0]){
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
