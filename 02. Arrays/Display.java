import java.util.*;

public class Display{
  public static void main (String[]args) throws Exception
  {
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt ();
    int m = scn.nextInt ();

    // input in array
    int arr[][] = new int[n][m];
    for (int i = 0; i < arr.length; i++){
      for (int j = 0; j < arr[i].length; j++){
        arr[i][j] = scn.nextInt ();
      }
    }

    System.out.println("Array rows = " + arr.length);
    System.out.println("Array columns = " + arr[0].length);
    
    // print array
    for (int i = 0; i < arr.length; i++){
      for (int j = 0; j < arr[i].length; j++){
        System.out.print (arr[i][j] + " ");
      }
      
      System.out.println ();
    }

    scn.close();
  }
}