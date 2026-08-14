class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        //Deque <Integer> st= new ArrayDeque<>();  // modern way to write 
        int n=heights.length;
        int [] NSE = new int[n];
        int [] PSE= new int[n];

        //1. Finding Next Samller Element 
        for(int i=n-1; i>=0; i--){
          while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
            st.pop();
          }
          if(st.isEmpty()){
            NSE[i]=n;
          }else{
            NSE[i]=st.peek();
          }
          st.push(i);    // we have to put index of next smaller element , not the element. 
        }
        st.clear();  // This is most important to CLEAR STACK . 

        //2. Finding Previous Smaller Element 
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
            st.pop();
          }
          if(st.isEmpty()){
            PSE[i]=-1;
          }else{
            PSE[i]=st.peek();
          }
          st.push(i);
        }

        //3. Ans =  Arr[i] * (NSE[i] - PSE[i] -1)
        int maxArea=0;
        for(int i=0; i<n; i++){
          maxArea = Math.max(maxArea, heights[i] * (NSE[i] - PSE[i] - 1));
        }
        return maxArea;

    }
}









