class Solution {
    public int countCommas(int n) {
        int ans=0;

        for(int d=1000;d<=n;d*=1000){
            ans+=n-d+1;
        }

        return ans;
    }
}