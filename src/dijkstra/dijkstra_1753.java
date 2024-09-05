package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dijkstra_1753 {

    static int [] distance;
    static int[][] matrix;
    static boolean []visited;

    static int V;
    static int K;

    static void dijkstra(){
        Queue<Integer> q = new LinkedList<>();
        distance[K] = 0;
        q.add(K);

        while(!q.isEmpty()){
            int nowV = q.poll();
            visited[nowV] = true;

            for(int i=1; i<=V; i++){
                if(!visited[i]){
                    if(distance[nowV] + matrix[nowV][i] < distance[i]){
                        distance[i] = distance[nowV] + matrix[nowV][i];
                        q.add(i);
                    }
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {
        final int MAX = Integer.MAX_VALUE-10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        matrix = new int[V+1][V+1];
        visited = new boolean[V+1];
        distance = new int[V+1];

        for(int i=1; i<=V;i++){
            distance[i] = MAX;
        }

        K = Integer.parseInt(br.readLine());
        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                if(i==j){
                    matrix[i][j] = 0;
                }
                else{
                    matrix[i][j] = MAX;
                }
            }
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            matrix[u][v] = w;
        }
        dijkstra();

        for(int i=1; i<=V; i++){
            if(distance[i] == MAX){
                System.out.println("INF");
            }else{
                System.out.println(distance[i]);
            }
        }
    }
}
