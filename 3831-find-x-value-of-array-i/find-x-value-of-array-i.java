class Solution {

    public long[] resultArray(int[] nums, int k) {
        int n=nums.length;
        long[] ans=new long[k];
        long[] dp=new long[k];

        for(int i=0;i<n;i++){
            long[] next=new long[k];

            next[nums[i]%k]++;

            for(int r=0;r<k;r++){
                int nr=(int)((long)r*nums[i]%k);
                next[nr]+=dp[r];
            }

            dp=next;

            for(int r=0;r<k;r++){
                ans[r]+=dp[r];
            }
        }

        return ans;
    }
}