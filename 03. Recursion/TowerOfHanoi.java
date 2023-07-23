import java.util.*;

public class TowerOfHanoi {
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int t1 = scn.nextInt();
    int t2 = scn.nextInt();
    int t3 = scn.nextInt();

    // first is sender, second is receiver, third is helper
    towerOfHanoi(n, t1, t2, t3);

    scn.close();
  }

  public static void towerOfHanoi(int n, int t1, int t2, int t3) {
    if (n==0) return;

    towerOfHanoi(n-1, t1, t3, t2);                          // will move n-1 disks from t1 to t3 using t2 as helper
    System.out.println(n + "[" + t1 + " -> " + t2 + "]");   // remaining last one disk, we'll move from t1 to t2
    towerOfHanoi(n-1, t3, t2, t1);                          // will move n-1 disks (that were moved earlier) to t2 from t3 using t1 as helper
  }
}