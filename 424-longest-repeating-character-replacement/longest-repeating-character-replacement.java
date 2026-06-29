class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int i = 0;
        int j = 0;
        int maxFreq = 0;
        int max = 0;

        while (j < s.length()) {

            int index = s.charAt(j) - 'A';
            freq[index]++;

            maxFreq = Math.max(maxFreq, freq[index]);

            if((j - i + 1) - maxFreq > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }

            max = Math.max(max, j - i + 1);
            j++;
        }

        return max;
    }
}