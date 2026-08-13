class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack <>();
        //Deque <Integer> st=new ArrayDeque<>();
        int n=asteroids.length;

        for(int i=0; i<n; i++){
            if(asteroids[i]> 0){
                st.push(asteroids[i]);
            }else{
                if(st.isEmpty()){
                    st.push(asteroids[i]);
                }else{
                
                  while(!st.isEmpty() && st.peek() > 0 && Math.abs(asteroids[i]) >st.peek() ){
                    st.pop();
                  }

                  if(!st.isEmpty() && Math.abs(asteroids[i]) == st.peek()){
                    st.pop();
                  }else if(st.isEmpty() || st.peek()<0){
                    st.push(asteroids[i]);
                  }
                  
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        Collections.reverse(list);

        int [] ans= new int[list.size()];
        for(int i=0; i<list.size(); i++){
         ans[i] = list.get(i);
        }
        return ans;

    }
}