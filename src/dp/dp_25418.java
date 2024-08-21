package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_25418 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");

        int A = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        int [] dp = new int[K+1];

        for(int i= A; i<=K; i++){
            if(!(i == A)){
                if(dp[i] == 0){
                    dp[i] = dp[i-1] + 1;
                }
                else{
                    dp[i] = Math.min(dp[i-1]+1, dp[i]);
                }
            }

            if(i*2 <= K){
                dp[i*2] = dp[i] + 1;
            }
        }

        System.out.println(dp[K]);
        br.close();

    }
}
