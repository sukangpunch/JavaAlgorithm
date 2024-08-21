package dp;

import java.io.*;

public class dp_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int [] dp = new int[n+1];

        dp[1] = 1;

        for(int i=2; i<=n; i++){
            if(i == 2){
                dp[2] = 3;
            }
            else{
                dp[i] = ((dp[i-1] % 10007)  + 2*(dp[i-2] % 10007)) %10007 ;
            }
        }
        bw.write(dp[n] + "\n");
        bw.flush();
        br.close();

    }
}
