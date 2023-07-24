import java.util.*;

public class SaddlePoint2D {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt ();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = scn.nextInt ();
            }
        }

        scn.close();

        // Saddle Point = min in that row but max in that column

        // Start iterating row wise
        for(int i=0; i < n; i++){

            // in first row, check j with lowest value
            int svj = 0;                            // smallest value j = we assume smallest value is in 0th col
            for(int j=1; j < n; j++){
                if(arr[i][j] < arr[i][svj]){        // we get another min in some col of that row
                    svj = j;                        // update svj with col number
                }
            }

            // for the j we obtain, we check if it's max in that column
            boolean flag = true;                    // initially we assume, svj's row is the max in that column

            for(int k=1; k < n; k++){
                if(arr[k][svj] > arr[i][svj]){      // we get another max in some col of that row
                    flag = false;                   // update svj with col number
                    break;                          // asa we get a bigger value, it means it's not the saddle point 
                                                    // so break & go to if flag cond'n
                }
            }

            if(flag == true){                       // will only be executed when we get a SP
                System.out.println(arr[i][svj]);
                return;
            }
        }

        // we'll come out loop only when all rows have been checked & flag was false for all, hence no SP
        System.out.println("No Saddle Point");


    }

}