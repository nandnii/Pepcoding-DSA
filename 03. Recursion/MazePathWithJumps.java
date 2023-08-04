import java.util.*;

public class MazePathWithJumps {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    ArrayList< String> paths = getMazePathsWithJumps(1, 1, n, m);
    System.out.println(paths);

    scn.close();
  }

  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  public static ArrayList< String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {

    // Return blank AL, means [.]
    if (sr == dr && sc == dc){
        ArrayList<String> BaseAns = new ArrayList<>();
        BaseAns.add("");
        return BaseAns;
    }

    // Return empty AL, means [], nothing will add in this when we do paths.add on this
    else if (sr > dr || sc > dc){
        ArrayList<String> BaseAns = new ArrayList<>();
        return BaseAns;
    }

    ArrayList< String> paths = new ArrayList<>();

    // horizontal moves
    for (int hms = 1; hms <= dc - sc; hms++) {          // max horizontal we can move as gap of dc & sc; smallest jump of h1, max of dc-sc
      ArrayList< String> hpaths = getMazePathsWithJumps(sr, sc + hms, dr, dc);
      for (String hpath : hpaths) {
        paths.add("h" + hms + hpath);
      }
    }

    // vertical moves
    for (int vms = 1; vms <= dr - sr; vms++) {        // max vertical we can move as gap of dr & sr; smallest jump of v1, max of dr-sr
      ArrayList< String> vpaths = getMazePathsWithJumps(sr + vms, sc, dr, dc);
      for (String vpath : vpaths) {
        paths.add("v" + vms + vpath);
      }
    }

    // diagonal moves
    for (int dms = 1; dms <= dr - sr && dms <= dc - sc; dms++) {
      ArrayList< String> dpaths = getMazePathsWithJumps(sr + dms, sc + dms, dr, dc);
      for (String dpath : dpaths) {
        paths.add("d" + dms + dpath);
      }
    }

    return paths;
  }
}