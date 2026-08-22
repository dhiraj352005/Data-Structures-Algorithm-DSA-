class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int l=0, r=0;
        
        int [] map = new int[26]; // hashMap to store the frequency of char
        int maxLen = 0;
        int maxFreq = 0;

        while(r<n){
           char ch = s.charAt(r);
           map[ch-'A']++;
           maxFreq = Math.max(maxFreq,map[ch-'A']);
           while((r-l+1) - maxFreq > k){  // invalid condtion , trim down the window 
              map[s.charAt(l) - 'A']--;
              l++;
            //   maxFreq = 0;         // Not contributing the ans as maxFreq is decresing . 
            //   for(int i=0; i<26; i++)   // editing the maxfreq
            //     maxFreq = Math.max(maxFreq, map[i]);
           }
              if((r-l+1) - maxFreq <= k) maxLen = Math.max(maxLen, r-l+1);
              r++;  
        }

        return maxLen;
    }
}
