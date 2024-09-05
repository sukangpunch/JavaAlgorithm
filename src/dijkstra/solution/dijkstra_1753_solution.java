package dijkstra.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dijkstra_1753_solution {
    static class Node{
        int end;
        int weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    static int []distance;
    static List<Node>[] list;
    static int K;
    static int V;

    //다익스트라 함수
    static void dijkstra(){
        // o1.weight - o2.weight는 두 Node의 weight 값을 뺀 결과를 반환합니다.
        // 이 값이 음수이면 o1이 o2보다 작다고 간주되어 o1이 우선순위 큐에서 앞에 오게 됩니다.
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

        distance[K] = 0;
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();     //현재 방문 정점
            for(int i=0; i<list[now.end].size(); i++){
                // 현재 정점과 연결된 간선들에 대해 판단
                Node next = list[now.end].get(i);

                // 현재 가중치 + 해당 정점으로 향하는 가중치 < 해당 정점으로의 최단경로 값
                if(now.weight + next.weight < distance[next.end]){
                    // 해당 정점으로 최단 경로 값을 업데이트 한다.
                    distance[next.end] = now.weight + next.weight;
                    // 다음 방문할 예정이므로 queue 에 넣어준다.
                    pq.add(new Node(next.end, distance[next.end]));
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        distance = new int[V+1];
        list = new List[V+1];

        for(int i= 1; i<=V; i++){
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v,w));
        }

        dijkstra();

        for(int i=1; i<=V; i++){
            if(distance[i] == Integer.MAX_VALUE)System.out.println("INF");
            else System.out.println(distance[i]);
        }


    }
}
