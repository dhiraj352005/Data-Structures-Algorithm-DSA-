class Solution {

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;

        if (n % 2 == 0) {
            return true;
        }

        int[] dp = new int[n];

        for (int start = n - 1; start >= 0; start--) {

            dp[start] = nums[start];

            for (int end = start + 1; end < n; end++) {

                int pickLeft = nums[start] - dp[end];
                int pickRight = nums[end] - dp[end - 1];

                dp[end] = Math.max(pickLeft, pickRight);
            }
        }

        return dp[n - 1] >= 0;
    }
}