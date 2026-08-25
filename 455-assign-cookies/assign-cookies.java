class Solution {
    public int findContentChildren(int[] g, int[] s) {  // g = children s = cookies 
        Arrays.sort(g);
        Arrays.sort(s);
        int m = s.length, n = g.length;
        int l=0, r=0;  // l = cookieIndex on array s ,  r= childrenIndex on greed array 
       
        while(l<m && r<n){
            if(g[r] <= s[l]){
                r++;
            }
            l++;
        }
        return r;

       
    }
}


/*


class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0;

        for(int i=0; i<g.length; i++){
            while(j < s.length && g[i] > s[j]){
                j++;
            }
            if(j < s.length && g[i] <= s[j++])
                count++;
        }
        return count;
    }
}

*/