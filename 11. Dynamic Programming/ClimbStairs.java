import java.util.*;

public class ClimbStairs {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] qb = new int[n + 1];
        int pathsMemo = countPathsMemo(n, qb);
        int pathsTab = countPathsTab(n);
        System.out.println(pathsMemo);
        System.out.println(pathsTab);

        scn.close();
    }

    public static int countPathsMemo(int n, int[] qb) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        if (qb[n] != 0) return qb[n];

        int p1 = countPathsMemo(n - 1, qb);
        int p2 = countPathsMemo(n - 2, qb);
        int p3 = countPathsMemo(n - 3, qb);

        qb[n] = p1 + p2 + p3;
        return p1 + p2 + p3;
    }

    public static int countPathsTab(int n){

        // make array of n+1 size
        int[] dp = new int[n+1];

        dp[0] = 1;      // ways to go from step 0 to step 0 is 1, i.e. stand there
        for(int i = 1; i <= n; i++){
            if(i==1){
                dp[i] = dp[i-1];
            }
            else if(i==2){
                dp[i] = dp[i-1] + dp[i-2];
            }
            else {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }

        return dp[n];
    }
}