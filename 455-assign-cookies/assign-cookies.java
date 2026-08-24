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