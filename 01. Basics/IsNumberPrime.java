import java.util.*;

public class IsNumberPrime {
    public static void main(String args[]) {
      Scanner scn = new Scanner(System.in);
      int t = scn.nextInt();
      for(int i=0; i<t; i++){     // 10^4
        int n = scn.nextInt();
        
        int count=0;
        for(int div=2; div*div<=n; div++){    //n was 10^9, root n will be ~10^5
          if(n%div == 0){
            count++;
            break;
          }
        }

        if(count==0){
          System.out.println("prime");
        }
        else{
          System.out.println("not prime");
        }
      }
      scn.close();
    }
}