class Solution {

    public int[] NSE(int[] row) {
        Stack<Integer> st = new Stack<>();
        int n = row.length;
        int[] nse = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && row[st.peek()] >= row[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    public int[] PSE(int[] row) {
        Stack<Integer> st = new Stack<>();
        int n = row.length;
        int[] pse = new int[n];

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && row[st.peek()] >= row[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pse;
    }

    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] height = new int[n];
        int maxArea = 0;

        for(int i = 0; i < m; i++) {

            // Build histogram for current row
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }

            int[] nse = NSE(height);
            int[] pse = PSE(height);

            for(int j = 0; j < n; j++) {
                int area = height[j] * (nse[j] - pse[j] - 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}