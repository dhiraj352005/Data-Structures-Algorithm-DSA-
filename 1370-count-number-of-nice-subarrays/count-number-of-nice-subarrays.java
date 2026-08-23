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
        sum += nums[r] % 2;              // if even number add 0 else 1  in sum 

        while(sum>k ){     // this loop rums overall in t.c = O(N) , Not for individual 
            sum -= nums[l] % 2;
            l++;
        }
        count += (r-l+1);
        r++;
       }
       return count;
    }


   public int numberOfSubarrays(int[] nums, int k) {
        /* No. of subarrays where (sum = k)      // ex. Sum 10 = (Sum <= 10) - (Sum <= 9)
           = 
           No. of subarrays where (sum <= k)
           -
           No. of subarrays where (sum <= k-1)
        */
        int ans = fun(nums, k) -  fun(nums, k-1);     // t.C = (2N) + (2N)  and space = 1
       
        return ans;
    }
}


