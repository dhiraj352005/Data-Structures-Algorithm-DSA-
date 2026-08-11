class Solution {
    public boolean isValid(String s) {
        Stack <Character> st = new Stack<>();
        // Deque st = new ArrayDeque<>();
        int n=s.length();
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(ch =='(' || ch =='[' || ch =='{'){
                st.push(ch);
            }else{
                    if(st.size() != 0){
                        if(ch == ')' && st.pop() != '(' ){
                        return false;
                        }else if(ch ==']' && st.pop() != '[' ){
                            return false;
                        }else if(ch =='}' && st.pop() != '{' ){
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
            
          }
            return st.size() == 0;
        }

      
    }





