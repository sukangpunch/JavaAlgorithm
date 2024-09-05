package floyd;

import java.io.*;
import java.util.StringTokenizer;

public class floyd_11562 {

    static int n;
    static int m;
    static int[][] structure;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int result = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        structure = new int[n+1][n+1];


        int max = 987654321;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i !=j)structure[i][j] = max;
            }
        }

        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            structure[u][v] = 0;
            structure[v][u] = (b==0) ? 1: 0;
        }


        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n;i++){
                for(int j = 1; j <= n; j++){
                    if(i == j)continue;
                    structure[i][j] = Math.min(structure[i][j], structure[i][k] + structure[k][j]);
                }
            }
        }

        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<K;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(structure[s][e] + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
