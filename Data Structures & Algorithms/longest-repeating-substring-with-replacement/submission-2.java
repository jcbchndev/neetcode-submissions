class Solution {
    public int characterReplacement(String s, int k) {
        // this requires a sliding window method where:
        // we want to keep a count of each char's frequency in a count array
        // to decide if the current window can support the amount of k replacements to make the longest consecutive string
        // we can check if length of the window - max freq of char <= k
        // if the diff is smaller than k, then that means the window has enough characters where it can be replaced up to k times
        // then, we can take the max of the current window against the current max to find the new max, then increase our window size
        // else, we will have to decrement the left side of the window, and decrease the count of the the decremented char.

        int i = 0;
        int[] count = new int[26];
        int maxFreq = 0;
        int maxLen = 1;
        for (int j = 0; j < s.length(); j++){
            int winSize = j - i + 1;
            char c = s.charAt(j);
            count[c - 'A']++;
            maxFreq = Math.max(maxFreq, count[c - 'A']);

            if (winSize - maxFreq > k){
                count[s.charAt(i)- 'A']--;
                i++;
            } else{
                maxLen = Math.max(maxLen, winSize);
            }
        }
        return maxLen;
    }
}
