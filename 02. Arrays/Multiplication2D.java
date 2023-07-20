import java.util.*;

public class Multiplication2D{

public static void main(String[] args) throws Exception {
    // write your code here

    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt ();
    int m = scn.nextInt ();

    // input in array1
    int[][] arr1 = new int[n][m];
    for (int i = 0; i < arr1.length; i++){
      for (int j = 0; j < arr1[i].length; j++){
        arr1[i][j] = scn.nextInt ();
      }
    }

    int a = scn.nextInt();
    int b = scn.nextInt();

    // input in array2
    int[][] arr2 = new int[a][b];
    for (int i = 0; i < arr2.length; i++){
      for (int j = 0; j < arr2[i].length; j++){
        arr2[i][j] = scn.nextInt ();
      }
    }

    scn.close();
    
    // columns of first array = rows of second array else multiplication cna't happen
    if(m != a){
        System.out.println("Invalid Input");
        return;
    }

    // product array
    int[][] ans = new int[n][b];
    for (int i = 0; i < ans.length; i++){
        for (int j = 0; j < ans[0].length; j++){
          for(int k = 0; k < m; k++){               //could also be k < a
            ans[i][j] += arr1[i][k] * arr2[k][j];
          }
        }
    }

    // print ans array
    for (int i = 0; i < ans.length; i++){
        for (int j = 0; j < ans[i].length; j++){
          System.out.print(ans[i][j] + " ");
        }

        System.out.println();
    }

 }

}