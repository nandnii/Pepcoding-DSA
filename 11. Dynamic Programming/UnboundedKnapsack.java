import java.util.*;

public class UnboundedKnapsack {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] valueArr = new int[n];
		for(int i=0; i<valueArr.length; i++){
			valueArr[i] = scn.nextInt();
		}

        int[] weightArr = new int[n];
		for(int i=0; i<weightArr.length; i++){
			weightArr[i] = scn.nextInt();
		}

		int target = scn.nextInt();

        scn.close();

		int[] dp = new int[target+1];
		dp[0] = 0;

		// Outer loop for looping on dp array on every index from 1 to last index
		for(int j=1; j<=target; j++){
            int max = 0;
            for(int i=0; i<weightArr.length; i++){
                int weight = weightArr[i];
                int value = valueArr[i];

                if(j >= weight){
                    int remainingVal = dp[j - weight];
                    int totalVal = value + remainingVal;

                    // Till here we get total value by including appropiriate weights
                    // Now we will calculate maximum in it
                    if(totalVal > max){
                        max = totalVal;
                    }
				}
            }

            dp[j] = max;
		}

        System.out.println(dp[target]);

	}
}