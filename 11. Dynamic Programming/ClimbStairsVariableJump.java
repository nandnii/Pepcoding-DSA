import java.util.*;

public class ClimbStairsVariableJump {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // this array contains number of steps that can be taken from ith stair
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();

        int[] dp = new int[n+1];
        int ans = cs_tab(n, dp, arr);
        System.out.println(ans);
    }

    // I'll do this question by tabulation because instead of recursion storage/memoization storing all values will be better
    // cause I have no clue which value i'll need (since variable jumps) plus I can't drill it down to a base case
    public static int cs_tab(int n, int[] dp, int[] arr){

        for(int i=n; i>=0; i--){
            if(i==n){
                dp[i] = 1;                  // means to move from n to n stair, there's one way => stand there
                continue;
            }
            int jumpsPossible = arr[i];     // arr[i] contains possible jumps from ith stair
            for(int j=1; j<=jumpsPossible && i+j<=n; j++){
                dp[i] = dp[i] + dp[i+j];    
            }
        }

        // to print dp array
        for(int ele: dp){
            System.out.print(ele + " ");
        }

        System.out.println();

        return dp[0];
    }


}