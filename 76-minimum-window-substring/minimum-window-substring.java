class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m = t.length();
        int l=0, r=0;
        int count=0;
        int startIndex = 0;
        int size = Integer.MAX_VALUE;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()) map.put(ch, map.getOrDefault(ch, 0)+1);
        
        while(r < n){

            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                if(map.get(ch) > 0){
                    count++;
                }
                map.put(ch, map.get(ch)-1);
            }

             // Valid substring found 
                while(count == m){
                    if(r-l+1  < size){
                        size = r-l+1;
                        startIndex = l;
                    }
                    char leftChar = s.charAt(l);
                    if(map.containsKey(leftChar)){
                       map.put(leftChar, map.get(leftChar)+1);
                       if(map.get(leftChar) > 0){
                        count--;
                       }
                    }
                    l++;
                }

            r++;
        }


        if (size == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIndex, startIndex + size);
    }
}




