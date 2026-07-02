class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (int i = 0; i < strs.size(); i++){
            encoded.append(strs.get(i).length());
            encoded.append("#");
            encoded.append(strs.get(i));
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {

        List<String> decoded = new ArrayList<>();
        
        int i = 0;

        while (i < str.length()){
            int j = i;
            while (str.charAt(j) != '#'){
                j++;
            }
            int lenOfWord = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j + 1, j + 1 + lenOfWord);

            decoded.add(word);
            
            i = j + 1 + lenOfWord;
        }

        return decoded;
    }
}
