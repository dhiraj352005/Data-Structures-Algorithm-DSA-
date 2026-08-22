class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int totalSubstrings=0;
        int count=0;

        int[] arr = new int[3];
        Arrays.fill(arr, -1);
        
        for(int i=0; i<n; i++){
           char ch = s.charAt(i);
           arr[ch-'a'] = count++;
           if(arr[0] != -1 && arr[1] != -1 && arr[2] != -1){  // meams all 3 char are present.
              // check last seen char
              int lastSeen = Math.min(arr[0], Math.min(arr[1], arr[2]) );
              totalSubstrings += lastSeen +1;    // All substring to the left . 
           }
        }

        return totalSubstrings;



    }
}



