package dijkstra.solution;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 일반적인 이차원배열 다익스트라로는 풀 수 없다
// 한 도시에서 다른 도시로 가능 버스가 여러개가 존재할 수 있기 때문. ex: 1 2 10, 1 2 50
// 고로 틀린 코드
public class dijkstra_1916_solution {
    static class Node implements Comparable<Node>{

        int node, value;
        public Node(int node, int value){
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static int N;

    static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean [] visited = new boolean[N+1];
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(n.node == end){
                return n.value;
            }
            visited[n.node] = true;

            for(Node next : graph.get(n.node)){
                if(!visited[next.node]){
                    pq.add(new Node(next.node, n.value + next.value));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new ArrayList<>();

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, value));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int result = dijkstra(s,e);
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
