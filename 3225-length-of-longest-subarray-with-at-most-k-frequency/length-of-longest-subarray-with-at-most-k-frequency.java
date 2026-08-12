class Solution {
public int maxSubarrayLength(int[] nums, int k) {
    int n=nums.length;
    Map<Integer,Integer> frequency = new HashMap<>();
     int start=0;
    int maxLen=0;

    for(int end=0;end<n;end++){
         frequency.put(nums[end],frequency.getOrDefault(nums[end],0)+1);

        while(frequency.get(nums[end])>k){
             frequency.put(nums[start],frequency.get(nums[start])-1);
            start++;
        }

      
         maxLen=Math.max(maxLen,end-start+1);
    }

    return maxLen;
}
}