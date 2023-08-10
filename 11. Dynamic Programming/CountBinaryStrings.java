import java.util.*;

public class CountBinaryStrings{

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        scn.close();
        
        // WITH DP ARRAY
        // int[] dp0 = new int[n+1];
        // int[] dp1 = new int[n+1];
        
        // for(int i=2; i<=n; i++){
        //     dp0[1] = 1;
        //     dp1[1] = 1;
        //     dp1[i] = dp0[i-1] + dp1[i-1];
        //     dp0[i] = dp1[i-1];
        // }

        // System.out.println(dp0[n] + dp1[n]);

        // WITH POINTERS (LESS SPACE)
        int prev0 = 1;
        int prev1 = 1;

        for(int i=2; i<=n; i++){
            int curr1 = prev0 + prev1;
            int curr0 = prev1;

            prev0 = curr0;
            prev1 = curr1;
        }

        System.out.println(prev0 + prev1);

    }

}