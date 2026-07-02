class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> group = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            int[] charFreq = new int[26];
            String word = strs[i];

            for (int j = 0; j < word.length(); j++){
                charFreq[word.charAt(j) - 'a']++;
            }
            String key = Arrays.toString(charFreq);
            group.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(group.values());
    }
}
