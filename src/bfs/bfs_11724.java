package bfs;

import java.io.*;
import java.util.StringTokenizer;

public class bfs_11724 {

    static int[][] map;
    static boolean[] visited;
    static int N;
    static int M;
    static int result;

    static void dfs(int x){
        visited[x] = true;

        for(int i=1; i<=N; i++){
            if(map[x][i] !=0 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
            map[c][r] = 1;
        }

        for(int i=1; i<=N; i++) {
            if (!visited[i]) {
                result++;
                dfs(i);
            }
        }

        bw.write(result+"");
        bw.flush();
        br.close();
    }
}
