class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int l=0, r=0, maxLength=0;

        while(r<n){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                if(map.get(ch) >= l){
                  l = map.get(ch) + 1;
                }
                map.put(ch, r);
            }else{
                map.put(ch, r);
            }
        
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        }

        return maxLength;
    }
}



