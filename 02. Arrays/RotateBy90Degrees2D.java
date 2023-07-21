import java.io.*;

public class RotateBy90Degrees2D {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(br.readLine());
      }
    }

    rotateby90(arr);
    display(arr);
  }

  public static void rotateby90(int[][] arr) {
    // Step 1 - Transpose
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {             // only take values in upper triangle
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
      }
    }
    // Step 2 - Reverse columns, row by row

    // firstly, swapping will happen in first row, first & last column, second & second last column
    // then next row & so on

    for (int i = 0; i < arr.length; i++) {
      int li = 0;
      int ri = arr[0].length - 1;
      while (li <= ri) {
        int temp = arr[i][li];
        arr[i][li] = arr[i][ri];
        arr[i][ri] = temp;

        li++;
        ri--;
      }
    }
  }

  public static void display(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}