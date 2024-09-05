package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dijkstra_1916 {

    static int N;
    static int [][] map;
    static boolean []visited;
    static int [] distance;

    static void dijkstra(int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        distance[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            visited[now] = true;

            for(int i=1; i<=N; i++){
                if(!visited[i]){
                    if(distance[now] + map[now][i] < distance[i]){
                        distance[i] = distance[now] + map[now][i];
                    }
                    q.add(i);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        final int INF = 100000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        distance = new int[N+1];

        for(int i=1; i <= N; i++){
            distance[i] = INF;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i == j){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = INF;
                }
            }
        }

        for(int i=0; i<M; i++){
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int value = Integer.parseInt(input[2]);
            map[start][end] = value;
            map[end][start] = value;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(distance[end]);
    }
}
