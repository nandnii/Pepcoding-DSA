import java.util.*;

public class ExitPoint2D {

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

        int dir = 0;    // 0-e, 1-s, 2-w, 3-n
        int i = 0;
        int j = 0; 

        while(true){
            dir = (dir + arr[i][j]) % 4;

            if(dir == 0){       // east
                j++;
            }
            else if(dir == 1){  // south
                i++;
            }
            else if(dir == 2){  // west
                j--;
            }
            else if(dir == 3){  // north 
                i--;
            }

            if(i < 0){              // exit point is top wall
                i++;
                break;
            }
            else if(j < 0){         // exit point is left wall
                j++;
                break;
            }
            else if(i == r){      // exit point is bottom wall
                i--;
                break;
            }
            else if(j == c){      // exit point is right wall
                j--;
                break;
            }
        }

        System.out.println(i);
        System.out.println(j);
    }

}