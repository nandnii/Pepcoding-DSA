import java.util.*;

public class MinCostInMazeTraversal {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] cost = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                cost[i][j] = scn.nextInt();
            }
        }

        scn.close();

        // // Solve from bottom right to top left (right to left traversal)
        int[][] dp = new int[r][c];
        
        for(int i=r-1; i>=0; i--){
            for(int j=c-1; j>=0; j--){
                if(i==r-1 && j==c-1){                   // last cell
                    dp[i][j] = cost[i][j];              // value of that cell (since it's last)
                }
                else if(i==r-1){                        // last row
                    dp[i][j] = cost[i][j] + dp[i][j+1];  // add right value to it
                }
                else if(j==c-1){                        // last column
                    dp[i][j] = cost[i][j] + dp[i+1][j];  // add bottom value to it
                }
                else{                                   // everything other than that
                    dp[i][j] = cost[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        System.out.println(dp[0][0]);


        // Solve from top left to bottom right (left to right traversal)
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                
                // first cell
                if(row == 0 && col == 0) cost[row][col] = cost[row][col];

                // first row (add left value)
                else if(row == 0 && col != 0) cost[row][col] = cost[row][col] + cost[row][col - 1];
                
                // first col (add down value)
                else if(col == 0 && row != 0) cost[row][col] = cost[row][col] + cost[row - 1][col];
                
                // anywhere else (add min of down & left value)
                else cost[row][col] = cost[row][col] + Math.min(cost[row - 1][col], cost[row][col - 1]);
            }
        }
        System.out.println(cost[r-1][c-1]);

    }

}