package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bfs_7576 {

    static class Node{
        int x;
        int y;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int [][] tomato;
    static int M;
    static int N;
    static Node[] nodes;
    static int days;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];
        nodes = new Node[]{new Node(-1, 0), new Node(1, 0), new Node(0, -1), new Node(0, 1)};

        Queue<Node> q1 = new LinkedList<>();

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                if(input[j].equals("1")){
                    q1.add(new Node(i,j));
                }
                tomato[i][j] = Integer.parseInt(input[j]);
            }
        }

        Queue<Node> q2 = new LinkedList<>();

        while(!q1.isEmpty()){
            int size = q1.size();
            for(int i=0; i<size; i++){
                q2.add(q1.poll());
            }
            while(!q2.isEmpty()){
                Node nowNode = q2.poll();
                for(int i=0; i<4; i++){
                    int nx = nowNode.x + nodes[i].x;
                    int ny = nowNode.y + nodes[i].y;

                    if(nx>=0 && nx<M && ny>=0 && ny<N && tomato[ny][nx] == 0){
                        q1.add(new Node(ny,nx));
                        tomato[ny][nx] = 1;
                    }
                }
            }
            days++;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tomato[i][j] == 0){
                    days = 0;
                }
            }
        }

        System.out.println(days-1);
    }
}
