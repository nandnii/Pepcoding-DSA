import java.util.*;

public class GoldMine {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] grid = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                grid[i][j] = scn.nextInt();
            }
        }
        scn.close();

        int[][] dp = new int[r][c];
        for(int j=c-1; j>=0; j--){
            for(int i=r-1; i>=0; i--){
                if(j==c-1){                 // last col          
                    dp[i][j] = grid[i][j];
                }
                else if(i==r-1){            // last row
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
                }
                else if(i==0){              // first row
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
                }
                else{                       // anywhere else
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1]));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0, j=0; i<r; i++){
            max = Math.max(max, dp[i][j]);
        }

        System.out.println(max);
    }

}