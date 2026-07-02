class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int max_area = Math.min(heights[i], heights[j]) * (j - i);

        while (i < j){
            max_area = Math.max(max_area, Math.min(heights[i], heights[j]) * (j - i));
            int next_left = i + 1;
            int next_right = j - 1;
            if (heights[j] > heights[i]){
                i++;
            } else {
                j--;
            }
        }

        return max_area;
    }
}
