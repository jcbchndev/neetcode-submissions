class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        for (char c: s1.toCharArray()){
            s1Count[c - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length() + 1; i++){
            int k = i;
            int[] pCount = new int[26];
            while (k - i < s1.length()){
                pCount[s2.charAt(k) - 'a']++;
                k++;
            }

                        System.out.println(Arrays.toString(s1Count));

            System.out.println(Arrays.toString(pCount));
            

            if (Arrays.toString(s1Count).equals(Arrays.toString(pCount))){
                return true;
            }

            pCount[s2.charAt(i) - 'a']--;
        }
        
        return false;
    }
}
