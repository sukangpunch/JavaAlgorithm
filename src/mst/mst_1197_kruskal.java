package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class mst_1197_kruskal {


    static int V;
    static int E;

    static int[] parent;
    static int[] rank;

    static PriorityQueue<Edge> edges;

    static int find(int x){ //부모노드를 계속해서 최상위 부모로 변경, 트리의 루트를 찾는 연산
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){ // 두 트리를 합치는 연산
        x = find(x);
        y = find(y);

        if(x==y){
            return;
        }

        if(rank[x] < rank[y]){// 랭크의 크기가 큰 집합에 다른 집합을 병합
            parent[x] = y;
        }else{
            parent[y] = x;
            if(rank[x] == rank[y]){ // 랭크의 크기가 같다면, 합친 후 부모노드 집합의 랭크를 키운다
                rank[x]++;
            }
        }
    }

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        rank = new int[V+1];
        edges = new PriorityQueue<>();

        for(int i=1; i<=V; i++){
            parent[i] = i;
        }

        for(int i=0; i< E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, weight));
        }

        int sum = 0;
        while(!edges.isEmpty()){
            Edge edge = edges.poll();

            if(find(edge.from) == find(edge.to)){
                continue;
            }
            union(edge.from, edge.to);
            sum += edge.weight;
        }
        System.out.println(sum);
    }
}
