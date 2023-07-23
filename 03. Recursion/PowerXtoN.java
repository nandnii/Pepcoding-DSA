import java.util.*;

public class PowerXtoN {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int x = scn.nextInt();
    int n = scn.nextInt();

    int powerlinear = PowerLinear(x, n);
    int powerlog = PowerLog(x, n);
    System.out.println(powerlinear);
    System.out.println(powerlog);

    scn.close();
  }

  // with S(n) = n
  public static int PowerLinear(int x, int n){

	// x = x * x^(n-1) 
    if(n==0) return 1;
    
    int pnm1 = PowerLinear(x, n-1);     // x to power of n-1
    int pn = x * pnm1;                  // x to power of n
    return pn;
  }

  // with S(n) = log(n)
  public static int PowerLog(int x, int n){

	// x = x^n/2 * x^n/2 
    if(n==0) return 1;
    int pnb2 = PowerLog(x, n/2);        // x to power of n by 2
    int pn = pnb2 * pnb2;               // x to power of n

    if (n%2 == 0){
      return pn;
    }
    else{
      return x * pn;
    }
  }

}