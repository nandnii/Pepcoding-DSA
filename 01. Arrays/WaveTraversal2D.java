import java.util.*;

public class WaveTraversal2D {

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner (System.in);
    int r = scn.nextInt ();
    int c = scn.nextInt ();

    // input in array1
    int[][] arr = new int[r][c];
    for (int i = 0; i < r; i++){
      for (int j = 0; j < c; j++){
        arr[i][j] = scn.nextInt ();
      }
    }

    scn.close();

    for(int col = 0; col < c; col++){
        if(col % 2 == 0){
            for(int row = 0; row < r; row++){
                System.out.println(arr[row][col] + " ");
            }
        }
        else if(col % 2 != 0){
            for(int row = r-1; row >= 0; row--){
                System.out.println(arr[row][col] + " ");
            }
        }
    }


 }

}