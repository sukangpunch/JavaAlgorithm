package dijkstra.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dijkstra_13549_solution {
    static class Node{
        int x;
        int time;

        public Node(int x, int time){
            this.x = x;
            this.time = time;
        }
    }

    static int N, K;
    static int[] visited;
    static int result = Integer.MAX_VALUE;
    static int max = 100000;
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[max+1];
        bfs();
        System.out.println(visited[K]-1);

    }

    public static void bfs(){
        q.offer(new Node(N, 1)); //방문 안한곳과 구별하기 위해서 초기값을 1로 해주고 나중에 1을 뺴준다.
        visited[N] = 1;

        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int time = node.time;

            if(x + 1 <= max && x+1 >= 0){
                if(visited[x+1] == 0 || visited[x+1] > time+1){
                    visited[x+1] = time+1;
                    q.add(new Node(x+1, time+1));
                }
            }

            if(x - 1 >=0 && x - 1<=max){
                if(visited[x-1] == 0 || visited[x-1] > time+1){
                    visited[x-1] = time+1;
                    q.add(new Node(x-1, time+1));
                }
            }

            if(x*2 <= max && x*2 >= 0){
                if(visited[x*2] == 0 || visited[x*2] > time){
                    visited[x*2] = time;
                    q.add(new Node(x*2, time));
                }
            }
        }
    }
}
