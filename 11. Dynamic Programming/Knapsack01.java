import java.util.*;

public class Knapsack01 {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] valueArr = new int[n];
        for(int i=0; i<n; i++){
            valueArr[i] = scn.nextInt();
        }

        int[] weightArr = new int[n];
        for(int i=0; i<n; i++){
            weightArr[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        scn.close();

        int[][] dp = new int[n+1][target+1];
        int r = n+1;
        int c = target+1;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i==0){                  // first row
                    dp[i][j] = 0;
                }
                else if(j==0){                  // first column
                    dp[i][j] = 0;
                }
                else{  
                    int weight = weightArr[i-1];      // TAKE NOTE, DP arr's first row is X (EMPTY)
                    int value = valueArr[i-1];
                    if(j < weight){                  // for all rows less than val, there use value above it as it can't contibute
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                       int choice1 = dp[i-1][j];                  // when element not included
                       int choice2 = dp[i-1][j-weight] + value;   // when element included
                       dp[i][j] = Math.max(choice1, choice2);

                    }
                }
            }
        }

        System.out.println(dp[r-1][c-1]);
    }
}