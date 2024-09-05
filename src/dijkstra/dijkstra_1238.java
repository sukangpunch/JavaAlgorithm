package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dijkstra_1238 {

    static class Node{
        int vertex;
        int weight;
        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static int N,M,X;
    static int[] goDistance, comeDistance;
    static List<Node>[] nodes, reverseNodes;


    static void dijkstra(List<Node>[] nodes, int [] distance){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Node(X,0));
        distance[X] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            for (Node next : nodes[now.vertex]) {
                if (distance[next.vertex] > distance[now.vertex] + next.weight) {
                    distance[next.vertex] = distance[now.vertex] + next.weight;
                    pq.add(new Node(next.vertex, distance[next.vertex]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        goDistance = new int[N+1];
        comeDistance = new int[N+1];
        nodes = new List[N+1];
        reverseNodes = new List[N+1];

        Arrays.fill(goDistance,Integer.MAX_VALUE);
        Arrays.fill(comeDistance,Integer.MAX_VALUE);

        for(int i=1; i<=N;i++){
            nodes[i] = new ArrayList<>();
            reverseNodes[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[start].add(new Node(end, weight));
            reverseNodes[end].add(new Node(start,weight));
        }

        dijkstra(nodes, goDistance);

        dijkstra(reverseNodes, comeDistance);

        int max= 0;
        for(int i=1; i<=N; i++){
            max = Math.max(max,goDistance[i] + comeDistance[i]);
        }

        System.out.println(max);

    }
}
