
class Solution {
    int N;
     int mx=1_00_001;
    int memo[];

    private boolean canWin(int pos){
        if(pos>=N)return false;
        if(memo[pos]!=-1)
             return memo[pos]>0;

        for(int i=1;i*i<mx;i++){
             int cur=i*i;
            if(pos+cur>N)break;

            if(!canWin(pos+cur)){
                 memo[pos]=1;
                return true;
            }
        }
        memo[pos]=0;
        return false;
    }

   public boolean  winnerSquareGame(int n){
        N=n;
        memo=new  int[n+1];
         Arrays.fill(memo,-1);
        return canWin(0);
     }
}

