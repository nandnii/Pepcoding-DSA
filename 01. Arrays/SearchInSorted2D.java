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

        int i = 0;
        int j = n-1;
        
        while(i<n && j>=0){
            if(arr[i][j] == d){
                System.out.println(i);
                System.out.println(j);
                return;
            }
            else if(arr[i][n-1] < d){   // if last value of row is smaller than d
                i++;                    // then move to next row
            }
            else{                       // enter else when we get (arr[i][n-1] >= d) 
                j--;                    // iterate in that row till left to find that element
            }
        }
        System.out.println("Not Found");
    }

}