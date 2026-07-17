class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> group = new HashMap<>();

        for (String word: strs){
            int[] freq = new int[26];

            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                freq[c - 'a']++;
            }

            String key = Arrays.toString(freq);
            
            group.putIfAbsent(key, new ArrayList<>());
            group.get(key).add(word);
        }

        return new ArrayList<>(group.values());
    }
}
