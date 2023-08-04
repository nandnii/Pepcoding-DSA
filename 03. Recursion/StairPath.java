import java.util.*;

public class StairPath {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);

        scn.close();
    }

    public static ArrayList<String> getStairPaths(int n) {
        
        // Return blank AL, means [.]
        if(n == 0){
            ArrayList<String> BaseAns = new ArrayList<>();
            BaseAns.add("");
            return BaseAns;
        } 
        
        // Return empty AL, means [], nothing will add in this when we do paths.add on this
        else if (n < 0){
            ArrayList<String> BaseAns = new ArrayList<>();
            return BaseAns;
        }

        ArrayList<String> path1 = getStairPaths(n-1); // Faith 1 => All paths from 0 to n-1
        
        ArrayList<String> path2 = getStairPaths(n-2); // Faith 2 => All paths from 0 to n-2

        ArrayList<String> path3 = getStairPaths(n-3); // Faith 3 => All paths from 0 to n-3

        ArrayList<String> paths = new ArrayList<String>();

        for(String path:path1){             // Add 1 step to make it reach n
            paths.add(1 + path);
        }

        for(String path:path2){             // Add 2 steps to make it reach n
            paths.add(2 + path);
        }

        for(String path:path3){             // Add 3 steps to make it reach n
            paths.add(3 + path);
        }

        return paths;
    }

}