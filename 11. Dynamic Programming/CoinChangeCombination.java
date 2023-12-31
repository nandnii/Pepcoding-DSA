import java.util.*;

public class CoinChangeCombination {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        scn.close();

        // Every index of this array means How many ways to pay [i] rs by coins available, so answer will be dp[target]
        int[] dp = new int [target+1];
        dp[0] = 1;                                  // one way to pay 0 that is don't pay anything

        for(int coin: coins){                      // run outer loop same number of times as the number of coins (iterations)
            for(int j=coin; j <= target; j++){      // run from coin number index to end of dp length (min coin can pay is its value & max is target)
                dp[j] = dp[j] + dp[j - coin];       // j - coinValue is basically the complement
            }
        }

        System.out.println(dp[target]);
    }
}