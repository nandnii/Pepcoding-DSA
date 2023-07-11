import java.util.*;

public class MazePathWithJumps {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    ArrayList< String> paths = getMazePaths(1, 1, n, m);
    System.out.println(paths);

    scn.close();
  }

  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  public static ArrayList< String> getMazePaths(int sr, int sc, int dr, int dc) {

    if (sr == dr && sc == dc){
        ArrayList<String> BaseAns = new ArrayList<>();
        BaseAns.add("");
        return BaseAns;
    }
    else if (sr > dr || sc > dc){
        ArrayList<String> BaseAns = new ArrayList<>();
        return BaseAns;
    }

    ArrayList< String> paths = new ArrayList< >();

    // horizontal moves
    for (int hms = 1; hms <= dc - sc; hms++) {
      ArrayList< String> hpaths = getMazePaths(sr, sc + hms, dr, dc);
      for (String hpath : hpaths) {
        paths.add("h" + hms + hpath);
      }
    }

    for (int vms = 1; vms <= dr - sr; vms++) {
      ArrayList< String> vpaths = getMazePaths(sr + vms, sc, dr, dc);
      for (String vpath : vpaths) {
        paths.add("v" + vms + vpath);
      }
    }

    for (int dms = 1; dms <= dr - sr && dms <= dc - sc; dms++) {
      ArrayList< String> dpaths = getMazePaths(sr + dms, sc + dms, dr, dc);
      for (String dpath : dpaths) {
        paths.add("d" + dms + dpath);
      }
    }

    return paths;
  }
}