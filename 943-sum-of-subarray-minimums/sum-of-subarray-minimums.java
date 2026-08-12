class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        // Deque<Integer> st=new ArrayDeque<>(); // Modern  way to use stack 
        int [] NSE=new int[n];
        int [] PSE=new int[n];

        // finding next smaller element 
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i] ){
                st.pop();
            }
            if(st.isEmpty()){
                NSE[i] = n;
            }else{
                NSE[i] = st.peek();
            }
                 st.push(i);
        }

        st.clear();

         // finding previous smaller element 
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i] ){
                st.pop();
            }
            if(st.isEmpty()){
                PSE[i] = -1;
            }else{
                PSE[i] = st.peek();
            }
              st.push(i);
        }

     
        
        long sum=0;
        int mod=1000000007;
        for(int i=0; i<n; i++){
            int pse_index=PSE[i];
            int nse_index=NSE[i];
            sum = (sum + (long) (i-pse_index) * (nse_index-i) * arr[i]) % mod;
        }

        return (int)sum;


    }
}