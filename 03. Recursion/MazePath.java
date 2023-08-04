import java.util.*;

public class MazePath {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> maze = getMazePaths(1, 1, n, m);
        System.out.println(maze);

        scn.close();

    }
    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        // Return blank AL, means [.]
        if(sr==dr && sc==dc){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
        
        ArrayList<String> Hpath = new ArrayList<String>();
        ArrayList<String> Vpath = new ArrayList<String>();
        
        // To reach from (1,1) to (3,3), we assume we can reach from (1,1) to (2,3) by recursion
        if(sr<dr){
            Hpath = getMazePaths(sr, sc, dr-1, dc);
        }
        
        // To reach from (1,1) to (3,3), we assume we can reach from (1,1) to (3,2) by recursion
        if(sc<dc){
            Vpath = getMazePaths(sr, sc, dr, dc-1);
        }
        
        ArrayList<String> finalPath = new ArrayList<String>();
        
        for(String path:Vpath){
            finalPath.add(path+"v");
        }
        
        for(String path:Hpath){
            finalPath.add(path+"h");
        }
        
        return finalPath;
    }

}