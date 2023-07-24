import java.util.*;

public class DiagonalTraversal2D {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt ();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = scn.nextInt ();
            }
        }

        scn.close();

        // k is basically the gap between i & j
        for(int k=0; k<arr.length; k++){
            for(int i=0, j=k; j<arr.length; i++, j++){
                System.out.println(arr[i][j]);
            }
        }
    }

}