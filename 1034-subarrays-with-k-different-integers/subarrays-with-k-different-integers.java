// Exactly K distinct
// = AtMost(K) - AtMost(K - 1)
//
// Time: O(N)
// Space: O(N)

class Solution {

    public int atMost(int[] nums, int k) {

        if (k == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int count = 0;

        while (r < nums.length) {

            // Add current element
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            // More than k distinct elements
            while (map.size() > k) {

                map.put(nums[l], map.get(nums[l]) - 1);

                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }

                l++;
            }

            // All subarrays ending at r
            // starting from l to r have <= k distinct elements
            count += (r - l + 1);

            r++;
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {

        return atMost(nums, k) - atMost(nums, k - 1);
    }
}