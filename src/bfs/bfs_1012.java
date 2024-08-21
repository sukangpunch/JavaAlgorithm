package bfs;

import java.io.*;
import java.util.StringTokenizer;

public class bfs_1012 {

    static class Node{
        int y;
        int x;

        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int[][] farm;
    static boolean[][] visited;
    static Node []node;
    static int result = 0;
    static int M;
    static int N;

    static void dfs(int y,int x){
        visited[y][x] = true;
        for(int i=0; i<4; i++){
            Node tmp = node[i];
            int ny = y+tmp.y;
            int nx = x+tmp.x;
            if(ny >= 0 && nx>=0 && ny < N && nx < M && !visited[ny][nx] && farm[ny][nx]==1){
                dfs(ny,nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        node = new Node[]{new Node(-1, 0), new Node(1, 0), new Node(0, -1), new Node(0, 1)};

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            farm = new int[N+1][M+1];
            visited = new boolean[N+1][M+1];

            for(int j = 0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                farm[Y][X] = 1;
            }

            for(int j=0; j<=N; j++){
                for(int k=0; k<=M; k++){
                    if(farm[j][k] == 1 && !visited[j][k]){
                        result++;
                        dfs(j,k);
                    }
                }
            }

            sb.append(result+"\n");
            result = 0;
        }
        bw.write(sb+"");
        bw.flush();
        br.close();
    }
}
