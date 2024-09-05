package prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

public class pfs_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] arr = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                // 각 좌표마다 해당 좌표의 박스 형태의 누적 합을 구해 놓는다. dp와 비슷
                arr[i][j] = arr[i][j-1] + arr[i-1][j] + Integer.parseInt(st.nextToken()) - arr[i-1][j-1];
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            int result = arr[er][ec] - arr[er][sc-1] - arr[sr-1][ec] + arr[sr-1][sc-1];
            sb.append(result+"\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
