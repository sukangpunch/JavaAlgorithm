package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greedy_16208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        long[] arr = new long[n];
        long line = 0;

        for(int i = 0; i<n; i++){
            long now = Integer.parseInt(st.nextToken());
            line += now;
            arr[i] = now;
        }
        long result = 0L;
        for(int i=0; i<n;i++)
        {
            result += (line - arr[i])*arr[i];
            line -= arr[i];
        }

        System.out.println(result);
    }
}
