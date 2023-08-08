import java.util.*;

public class CoinChangePermutation {

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
        
        // amount is running on dp arr, from 1 (cause dp[0] is already 1) to target amount (last index)
        for(int amt=1; amt <= target; amt++){       
            for(int coin: coins){                   // run loop for each coin
                if(coin <= amt){
                    int remainingAmt = amt - coin;
                    dp[amt] = dp[amt] + dp[remainingAmt];
                }
            }
        }

        System.out.println(dp[target]);
    }
}