import java.util.*;

public class DisplayArrayElements {
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    // input in array
    int[] arr = new int[n]; 
    for(int i=0; i<n; i++){
      arr[i] = scn.nextInt();
    }

    DisplayArr(arr, 0);

    scn.close();
  }

  public static void DisplayArr(int[] arr, int idx) {
    if(idx >= arr.length) return;

    System.out.println(arr[idx]); // print first element
    DisplayArr(arr, idx+1);       // Consquent elements will be printed by recursion
  }
}