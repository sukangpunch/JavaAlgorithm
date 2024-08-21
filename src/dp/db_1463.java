package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class db_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int cnt = 0;

        int [] dp = new int[X+1];

        for(int i=X; i > 1; i--){
            if(i % 3 == 0) {
                if(dp[i/3] == 0){
                    dp[i/3] = dp[i] + 1;
                }else{
                    dp[i/3] = dp[i]+1 < dp[i/3] ? dp[i] + 1 : dp[i/3];
                }
            }
            if(i % 2 == 0){
                if(dp[i/2] == 0){
                    dp[i/2] = dp[i] + 1;
                }else{
                    dp[i/2] = dp[i]+1 < dp[i/2] ? dp[i] + 1 : dp[i/2];
                }
            }
            if(dp[i-1] == 0){
                dp[i-1] = dp[i]+1;
            }else{
                dp[i-1] = dp[i]+1 < dp[i-1] ? dp[i]+1 : dp[i-1];
            }
        }
        System.out.println(dp[1]);

    }
}
