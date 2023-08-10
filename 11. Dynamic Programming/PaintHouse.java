import java.util.*;

public class PaintHouse {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        scn.close();

        int[][] dp = new int[n][3];

        dp[0][0] = arr[0][0];     // DP first column is red colour
        dp[0][1] = arr[0][1];     // DP first column is blue colour
        dp[0][2] = arr[0][2];     // DP first column is green colour

        for(int house=1; house < n; house++){
            // To paint red on this, red of this plus min of blue & green cost from previous
            dp[house][0] = dp[house - 1][0] + Math.min(dp[house - 1][1], dp[house - 1][2]);

            // To paint blue on this, red of this plus min of red & green cost from previous
            dp[house][1] = dp[house - 1][1] + Math.min(dp[house - 1][0], dp[house - 1][2]);

            // To paint green on this, red of this plus min of red & blue cost from previous
            dp[house][2] = dp[house - 1][2] + Math.min(dp[house - 1][0], dp[house - 1][1]);
        }

        int ans = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(ans);

    }
}