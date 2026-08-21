class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int l=0, r=0, length=0;

        while(r<n){
            if(!map.containsKey(s.charAt(r))){
               map.put(s.charAt(r), r);
            }else{
                int removeCharUpToThisIndex = map.get(s.charAt(r));
                while(l<= removeCharUpToThisIndex){
                    map.remove(s.charAt(l++));
                }
                map.put(s.charAt(r),r );
            }
            length = Math.max(length, r-l+1);
            r++;
        }

        return length;
    }
}



