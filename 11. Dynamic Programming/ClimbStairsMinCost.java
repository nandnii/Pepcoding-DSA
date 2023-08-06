import java.util.*;

public class ClimbStairsMinCost {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // this array contains the cost to be on that stair
        int[] cost = new int[n];
        for(int i=0; i<n; i++){
            cost[i] = scn.nextInt();
        }
        scn.close();

        int[] dp = new int[n];
        int ansMemo = Math.min(minCostMemo(n-1,dp,cost),minCostMemo(n-2,dp,cost));
        int ansTab = minCostTab(n,dp,cost);
        int ansPointers = minCostPointers(n,cost);
        System.out.println(ansMemo);
        System.out.println(ansTab);
        System.out.println(ansPointers);
    }

    public static int minCostMemo(int n, int[] dp, int[] cost){
        if(n<=1) return dp[n] = cost[n];

        if(dp[n] != 0) return dp[n];

        dp[n] = cost[n] + Math.min(minCostMemo(n-1, dp, cost), minCostMemo(n-2, dp, cost));
        
        return dp[n];
    }

    public static int minCostTab(int n, int[] dp, int[] cost){
        for (int i=0; i<n; i++) {
            if (i<2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }

    public static int minCostPointers(int n, int[] cost){
        int first = cost[0];
        int second = cost[1];
        for (int i=2; i<n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }

        return Math.min(first, second);
    }

}