import java.util.*;

public class ClimbStairsMinMoves {

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

        Integer[] dp = new Integer[n + 1];        // in Integer array, default value is null, not 0 (unlike int array)
        int ans = minMoves(n, dp, arr);
        System.out.println(ans);
    }

    // I'll do this question by tabulation because instead of recursion storage/memoization storing all values will be better
    // cause I have no clue which value i'll need (since variable jumps) plus I can't drill it down to a base case
    public static int minMoves(int n, Integer[] dp, int[] arr){
        for(int i=n; i>=0; i--){
            if(i==n){
                dp[i] = 0;                  // to move from n to n stair, there's no move, just stand there
                continue;
            }

            int jumpsPossible = arr[i];             // arr[i] contains possible jumps from ith stair
            
            if (jumpsPossible == 0) continue;       // if 0 then let it remain null cause no moves possible
            
            int max = Integer.MAX_VALUE;            // take an abritrary number to calculate max amongst dp values
            for (int j = 1; j <= jumpsPossible && i + j <= n; j++) {
                if (dp[i + j] != (Integer)null) {
                    // if will make sure if compaision values are all null, 
                    // then return null from this too cause no moves possible
                    max = Math.min(max, dp[i + j]);
                }
            }
            
            if (max != Integer.MAX_VALUE)
                dp[i] = max + 1;
        }

        // to print dp array
        for(int i=0;i<dp.length;i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        return dp[0];
    }

}

// Good example for dry run
// For arr[i] = [3,3,0,2,1,2,4,2,0,0]
// Ans dp[i]  = [4,4,N,3,3,2,1,N,N,N,0]
// that is best way is arr[0] to arr[3] to arr[5] to arr[6] to end (10th stair)