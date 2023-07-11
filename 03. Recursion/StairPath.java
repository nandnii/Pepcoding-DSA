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
        if(n == 0){
            ArrayList<String> BaseAns = new ArrayList<>();
            BaseAns.add("");
            return BaseAns;
        } else if (n < 0){
            ArrayList<String> BaseAns = new ArrayList<>();
            return BaseAns;
        }

        ArrayList<String> path1 = getStairPaths(n-1); // Faith 1 => All paths from n-1 to 0
        
        ArrayList<String> path2 = getStairPaths(n-2); // Faith 2 => All paths from n-2 to 0

        ArrayList<String> path3 = getStairPaths(n-3); // Faith 3 => All paths from n-3 to 0

        ArrayList<String> paths = new ArrayList<String>();

        for(String path:path1){
            paths.add(1 + path);
        }

        for(String path:path2){
            paths.add(2 + path);
        }

        for(String path:path3){
            paths.add(3 + path);
        }

        return paths;
    }

}