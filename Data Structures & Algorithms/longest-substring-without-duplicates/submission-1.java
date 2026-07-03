class Solution {
    public int lengthOfLongestSubstring(String s) {
        // simple solution would be to iterate over each char and continue to the end of the string until we find a repeated char
        // calculate length of that sequence and call the max function on it

        int i = 0;
        int longestSeq = 0;
        Map<Character, Integer> seen = new HashMap<>();

        for (int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            if (seen.containsKey(c)){ // when we hit a dup
                int lastSeenIdx = seen.get(c);
                if (lastSeenIdx >= i){ // if prev occurence is inside the window
                    i = lastSeenIdx + 1;
                }
            }

            seen.put(c,j);
            longestSeq = Math.max(longestSeq, j - i + 1);
        }

        return longestSeq;
    }
}
