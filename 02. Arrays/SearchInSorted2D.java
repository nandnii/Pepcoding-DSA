import java.util.*;

public class SearchInSorted2D {

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

        int d = scn.nextInt ();

        scn.close();

        // for(int i=0; i<n; i++){
        //     if(arr[i][n-1] < d){    // if last value of row is smaller than d, then move to next row
        //         break;
        //     }
        //     else{               // (arr[i][n-1] <= d)
        //         for(int j=n-1; j>=0; j++){
        //             if(arr[i][j] == d){
        //                 System.out.println(arr[i][j]);
        //             }
        //         }
        //     }
        // }


        int i = 0;
        while(i<n){
            if(arr[i][n-1] < d){            // if last value of row is smaller than d, then move to next row
                i++;
            }
            else{                           // enter else when we get (arr[i][n-1] >= d)
                for(int j=n-1; j>=0; j--){  // iterate in that row till left to find that element
                    if(arr[i][j] == d){
                        System.out.println(i);
                        System.out.println(j);
                        return;
                    }
                }
            }
        }

        System.out.println("Not Found");

    }

}