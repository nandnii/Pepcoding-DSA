import java.util.*;

public class SubArrays{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[] arr = new int[n]; 
    for(int i=0; i<arr.length; i++){
        arr[i] = scn.nextInt();
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            for(int k=i; k<=j; k++){
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }

    scn.close();
 }

}