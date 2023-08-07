import java.util.*;

public class TargetSumSubsets {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        scn.close();

        boolean[][] dp = new boolean[n+1][target+1];
        int r = n+1;
        int c = target+1;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i==0 && j==0){               // first cell
                    dp[i][j] = true;
                }
                else if(i==0){                  // first row
                    dp[i][j] = false;
                }
                else if(j==0){                  // first column
                    dp[i][j] = true;
                }
                else{                           // anywhere else
                    if(dp[i-1][j] == true){     // case when ele isn't included in sum
                        dp[i][j] = true;
                    }
                    else{                       // case when ele is included in sum
                        int val = arr[i-1];     // TAKE NOTE, DP arr's first row is X (EMPTY)
                        if(j >= val){           // for all rows less than Val, there automatically value will depend on above vals;
                            if(dp[i-1][j-val]){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(dp[r-1][c-1]);
    }
}