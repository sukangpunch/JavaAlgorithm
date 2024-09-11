package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class mst_1922 {

    static class Edge implements Comparable<Edge>{
        private int from;
        private int to;
        private int cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    static int N;
    static int M;
    static int []parent;
    static int []rank;
    static PriorityQueue<Edge> pq;

    static int find(int x){
        if(parent[x] == x)return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x==y){
            return;
        }

        if(rank[x] < rank[y]){
            parent[x] = y;
        }else{
            parent[y] = x;
            if(rank[x] == rank[y]){
                rank[x]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        rank = new int[N+1];
        pq = new PriorityQueue<>();

        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(to,from,cost));
        }

        int sum = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            if(find(edge.from) == find(edge.to)){
                continue;
            }
            union(edge.from, edge.to);
            sum += edge.cost;
        }
        System.out.println(sum);
    }
}
