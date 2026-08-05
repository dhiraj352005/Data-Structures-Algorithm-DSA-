class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;

        int winner = nums[0];
        int count=1;

        for(int i=1; i<n; i++){
           if(nums[i] != winner){
            count--;
           }else{
            count++;
           }
           if(count == 0){
            winner = nums[i];
            count=1;
           }
        }

        return winner;
    }
}