// Most Optimal Solution 
// T.C = O(2N + 2N)
// S.C=O(1)

class Solution {
    public int fun(int[]nums, int k){
       int n=nums.length;
       int count=0;
       int sum=0;
       int l=0, r=0;

       if(k < 0) return 0;   // sum < 0 not possible in this question bcoz all elements >= 0

       while(r<n){      // t.c = O(N)
        sum += nums[r];

        while(sum>k ){     // this loop rums overall in t.c = O(N) , Not for individual 
            sum -= nums[l];
            l++;
        }
        count += (r-l+1);
        r++;
       }
       return count;
    }


    public int numSubarraysWithSum(int[] nums, int goal) {
        /* No. of subarrays where (sum = k)      // ex. Sum 10 = (Sum <= 10) - (Sum <= 9)
           = 
           No. of subarrays where (sum <= k)
           -
           No. of subarrays where (sum <= k-1)
        */
        int ans = fun(nums, goal) -  fun(nums, goal-1);     // t.C = (2N) + (2N)  and space = 1
       
        return ans;
    }
}






// Better Approach 

/* 
// Prefix sum+ Hashmap 

// T.C = O(N)
// S.C=O(N)

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

*/



