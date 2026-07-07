class Solution {

    public String encode(List<String> strs) {
        List<String> encoded = new ArrayList();

        for (String word : strs){
            encoded.add(String.valueOf(word.length()));
            encoded.add("#");
            encoded.add(word);
        }

        return String.join("", encoded);
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList();
        // 5#Hello5#World
        int i = 0;
        int j = 0;
        while (i < str.length()){
            while (str.charAt(j) != '#'){
                j++;
            }
            int lenOfWord = Integer.parseInt(str.substring(i,j));
            String word = str.substring(j + 1, j + 1 + lenOfWord); 

            decoded.add(word);
            i = j + 1 + lenOfWord;
            j = i;
        }
        return decoded;
    }
}
