class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // Sliding window problem 
        int n=cardPoints.length;
        int maxPoints=0;
        for(int i=0; i<k; i++){
            maxPoints += cardPoints[i];
        }
        int ans=maxPoints;

        int endIndex=n-1;
        for(int i=k-1;i>=0; i--){
            maxPoints -= cardPoints[i];
            maxPoints += cardPoints[endIndex];
            ans = Math.max(ans, maxPoints);
            endIndex--;
        }
        return ans;

    }
}

