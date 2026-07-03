class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> group = new HashMap<>();

        for (String word: strs){
            int[] freq = new int[26];
            for (int i = 0; i < word.length(); i++){
                freq[word.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(freq);

            if (group.containsKey(key)){
                group.get(key).add(word);
            } else {
                group.put(key, new ArrayList<String>(List.of(word)));
            }
        }
        
        return new ArrayList<>(group.values());
        
    }
}
