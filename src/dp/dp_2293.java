package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dp_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] coin = new int[n];

        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);

        int [] dp = new int[k+1];
        dp[0] = 1;

        for(int i=0; i<n; i++){
            int coinValue = coin[i];
            for(int j = coinValue; j<= k; j++){
                dp[j] += dp[j - coinValue];
            }
        }

        System.out.println(dp[k]);

    }
}
