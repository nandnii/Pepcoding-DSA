import java.util.*;

public class PaintHouse2 {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int c = scn.nextInt();

        int[][] arr = new int[n][c];
        for(int i=0; i<n; i++){
            for(int j=0; j<c; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        scn.close();

        int[][] dp = new int[n][c];

        // APPROACH 2 - O(n^2) Complxity - BETTER
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;

        for(int j=0; j<c; j++){
            dp[0][j] = arr[0][j];       // For house 1, we copy values from arr to dp
            
            // Calculate least & second least for first row
            if(dp[0][j] <= least){
                sleast = least;
                least = dp[0][j];
            }
            else if(dp[0][j] <= sleast){
                sleast = dp[0][j];
            }
        }

        for(int house=1; house < n; house++){
            int newLeast = Integer.MAX_VALUE;
            int newSleast = Integer.MAX_VALUE;

            for(int j=0; j < c; j++){
                if(dp[house-1][j] == least){
                    dp[house][j] = arr[house][j] + sleast;
                } else{
                    dp[house][j] = arr[house][j] + least;
                }

                // Calculate new least & new second least for current row
                if(dp[house][j] <= newLeast){
                newSleast = newLeast;
                newLeast = dp[house][j];
                }
                else if(dp[house][j] <= newSleast){
                    newSleast = dp[house][j];
                }
            }

            least = newLeast;
            sleast =  newSleast;

            System.out.println(least);

        }

        // APPROACH 1 - O(n^3) Complxity - NOT GOOD

        // for(int j=0; j<c; j++){
        //     dp[0][j] = arr[0][j];       // For house 1, we copy values from arr to dp
        // }

        // for(int house = 1; house < n; house++){     // iterate on houses (rows)
        //     for(int j=0; j < c; j++){               // iterate on colours (columns)
        //         int min = Integer.MAX_VALUE;

        //         // Iterate on all values on i-1 row to calculate minimun of previous row
        //         for(int k=0; k < c; k++){
        //             if(k != j){
        //                 if(arr[house-1][k] < min){
        //                     min = arr[house-1][k];
        //                 }
        //             }
        //         }

        //         dp[house][j] = arr[house][j] + min;
        //     }
        // }

        // // Calculate min of last row (house) to get min cost
        // int min = Integer.MAX_VALUE;

        // // Iterate on all values on i-1 row to calculate minimun of previous row
        // for(int k=0; k < c; k++){
        //     if(arr[n-1][k] < min){
        //         min = arr[n-1][k];
        //     }
        // }

        // System.out.println(min);

    }
}