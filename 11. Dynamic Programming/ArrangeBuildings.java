import java.util.*;

public class ArrangeBuildings{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        int prevBuilding = 1;
        int prevSpace = 1;

        for(int i=2; i<=n; i++){
            int currBuilding = prevSpace;
            int currSpace = prevSpace + prevBuilding;

            prevBuilding = currBuilding;
            prevSpace = currSpace;
        }

        int total = (prevBuilding + prevSpace);
        System.out.println(total * total);

    }

}