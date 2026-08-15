class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb= new StringBuilder(num);
        int n=num.length();
        int i=0;
        if(n == k) return "0";
         while(k > 0 && sb.length() > 1 && i<sb.length()-1){
            int first= sb.charAt(i)-'0';
            int sec = sb.charAt(i+1)-'0';
            if (first > sec) {
                sb.deleteCharAt(i);
                k--;

                if (i > 0) {
                    i--;
                }
            } 
            else {
                i++;
            }
            
         }
           while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
         while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
         }
         if(sb.length() == 0){
            return "0";
         }
         return String.valueOf(sb);

    }
}




