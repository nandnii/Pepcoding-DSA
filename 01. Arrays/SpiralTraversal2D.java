import java.util.*;

public class SpiralTraversal2D {

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

        int minr = 0;
        int minc = 0;
        int maxr = r-1;
        int maxc = c-1;

        int total_elements = r * c;
        int count = 0;

        while(count < total_elements){
            // count < total_elements cond' added in for loop cause for last iteration all elements don't have to be printed
            // so it'll keep a check so one element isn't printed twice

            
            // left wall
            for(int i=minr, j=minc; i<=maxr && count < total_elements; i++){
                System.out.println(arr[i][j]);
                count++;
            }
            minc++;

            // bottom wall
            for(int i=maxr, j=minc; j<=maxc && count < total_elements; j++){
                System.out.println(arr[i][j]);
                count++;
            }
            maxr--;

            // right wall
            for(int i=maxr, j=maxc; i>=minr && count < total_elements; i--){
                System.out.println(arr[i][j]);
                count++;
            }
            maxc--;

            // top wall
            for(int i=minr, j=maxc; j>=minc && count < total_elements; j--){
                System.out.println(arr[i][j]);
                count++;
            }
            minr++;


        } 
    }

}