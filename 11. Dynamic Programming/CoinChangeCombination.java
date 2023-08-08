import java.util.*;

public class CoinChangeCombination {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        int amt = scn.nextInt();

        scn.close();

        // Every index of this array means How many ways to pay [i] rs by coins available, so answer will be dp[amt]
        int[] dp = new int [amt+1];
        dp[0] = 1;                                  // one way to pay 0 that is don't pay anything
    
        for(int i=0; i<arr.length; i++){            // run outer loop same number of times as the number of coins (iterations)
            int coinValue = arr[i];
            for(int j=coinValue; j<dp.length; j++){     // run from coin number index to end of dp length
                dp[j] = dp[j] + dp[j - coinValue];      // j - coinValue is basically the complement
            }
        }

        System.out.println(dp[amt]);
    }
}