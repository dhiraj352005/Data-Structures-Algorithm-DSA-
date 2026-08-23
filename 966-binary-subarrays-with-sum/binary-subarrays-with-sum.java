class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0, n=nums.length, sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i=0; i<n; i++){
            sum = sum + nums[i];
            int prefixSum = sum-goal;  // currentSum = PrefixSum + K
            if(map.containsKey(prefixSum)){
                count =  count + map.get(prefixSum);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        return count;
    }
}




