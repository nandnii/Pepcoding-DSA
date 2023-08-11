import java.util.*;

public class PaintFences {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int f = scn.nextInt();
        int c = scn.nextInt();

        scn.close();

        long last2same = c * 1;
        long last2diff = c * (c-1);
        long total = last2same + last2diff;

        // loop on fences
        for(int i = 3; i <= f; i++){
            last2same = last2diff * 1;
            last2diff = total * (c-1);
            total = last2same + last2diff;
        }

        System.out.println(total);
    }
}