package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dijkstra_13549 {

    static class Node{
        int x;
        int time;

        public Node(int x, int time){
            this.x = x;
            this.time = time;
        }
    }

    static int N, K;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    static int max = 100000;
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[max+1];
        bfs();
        System.out.println(result);

    }

    public static void bfs(){
        q.offer(new Node(N, 0));
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int time = node.time;
            visited[x] = true;

            if(x == K) result = Math.min(result, time);

            if(x*2 <= max && !visited[x*2])q.offer(new Node(2*x, time));
            if(x+1 <= max && !visited[x+1])q.offer(new Node(x+1, time+1));
            if(x-1 >= 0 && !visited[x-1]) q.offer(new Node(x-1, time+1));
        }
    }
}
