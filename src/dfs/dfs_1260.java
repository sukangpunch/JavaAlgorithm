package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfs_1260 {

    static int [][] graph;
    static boolean [] visited;
    static int N;
    static int M;
    static int V;

    static void dfs(int x){
        visited[x] = true;
        System.out.print(x + " ");

        for(int i=1; i<=N; i++){
            if(graph[x][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while(!q.isEmpty()){
            int now = q.poll();
            if(visited[now]){continue;}
            visited[now] = true;
            System.out.print(now + " ");
            for(int i=1; i<=N;i++){
                if(graph[now][i] == 1 && !visited[i]){
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s][e] = 1;
            graph[e][s] = 1;
        }

        visited = new boolean[N+1];
        dfs(V);
        visited = new boolean[N+1];
        System.out.println();
        bfs(V);
        br.close();
    }
}
