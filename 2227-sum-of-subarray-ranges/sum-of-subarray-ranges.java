class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> st= new Stack<>();
        int n=nums.length;

        // 1. Sum of subarray maximum 
         int [] NGE = new int[n];
         int [] PGE = new int[n];

         for(int i=n-1; i>=0; i--){  // Next Greater Element 
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                NGE[i] = n;
            }else{
                NGE[i]=st.peek();
            }
            st.push(i);
         }
         st.clear();

         for(int i=0; i<n; i++){   // Previous Greater Element 
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                PGE[i] = -1;
            }else{
                PGE[i]=st.peek();
            }
            st.push(i);
         }
         st.clear();


        // 2. Sum of subaaryy minimum 
         int [] NSE = new int[n];
         int [] PSE = new int[n];

         for(int i=n-1; i>=0; i--){  // Next Smaller Element 
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                NSE[i] = n;
            }else{
                NSE[i]=st.peek();
            }
            st.push(i);
         }
         st.clear();

         for(int i=0; i<n; i++){   // Previous Smaller Element 
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                PSE[i] = -1;
            }else{
                PSE[i]=st.peek();
            }
            st.push(i);
         }



      


       // 3. Ans = Sum of subarray maximum - sum of subarray minimum 
        long sum_of_subarray_maximum=0;
        
        for(int i=0; i<n; i++){
            int nge_index=NGE[i];
            int pge_index=PGE[i];
            sum_of_subarray_maximum += ( (long) (i-pge_index) * (nge_index-i) * nums[i]) ;
        }


       long sum_of_subarray_minimum=0;
       
        for(int i=0; i<n; i++){
            int pse_index=PSE[i];
            int nse_index=NSE[i];
           sum_of_subarray_minimum += ((long) (i-pse_index) * (nse_index-i) * nums[i]) ;
        }

        return sum_of_subarray_maximum-sum_of_subarray_minimum;

    }
}




