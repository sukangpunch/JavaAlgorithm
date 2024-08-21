package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dp_9461 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int [] caseList = new int[T];

        for(int i=0; i<T; i++){
            caseList[i] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(caseList).max().getAsInt();
        long []dp = new long[max+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<max; i++){
            dp[i] = dp[i-3]+dp[i-2];
        }

        for(int i=0; i<T; i++){
            System.out.println(dp[caseList[i]-1]);
        }

        br.close();
    }
}
