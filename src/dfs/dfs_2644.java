package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs_2644 {
    static int [][] family;
    static boolean [] visited;
    static int result = 0;
    static int N;
    static int targetX;
    static int targetY;

    static void dfs(int start, int end, int cnt){
        if(start == end){
            result = cnt;
            return;
        }
        visited[start] = true;
        for(int i = 1; i <= N; i++){
            if(family[start][i] == 1 && !visited[i]){
                dfs(i,end,cnt+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        family = new int[N+1][N+1];
        visited = new boolean[N+1];

        targetX = Integer.parseInt(st.nextToken());
        targetY = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            family[x][y] = family[y][x] = 1;
        }

        dfs(targetX, targetY, result);
        result = result == 0 ? -1 : result;
        System.out.println(result);
    }
}
