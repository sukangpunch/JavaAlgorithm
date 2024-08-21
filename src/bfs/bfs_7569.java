package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_7569 {

    static class Node{
        private int x;
        private int y;
        private int z;
        protected Node(int z, int y, int x){
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
    static int [][][] tomato;
    static Node []nodes;

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nodes = new Node[]{new Node(0,0,1), new Node(0,0,-1),
                new Node(0,-1,0), new Node(0, 1, 0),
                new Node(1,0,0), new Node(-1,0,0)};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];
        Queue<Node> q1 = new LinkedList<>();

        for(int k=0; k < H; k++){
            for(int i=0; i<N; i++){
                String [] str = br.readLine().split(" ");
                for(int j=0; j<M; j++){
                    tomato[k][i][j] = Integer.parseInt(str[j]);
                    if(str[j].equals("1")){
                        q1.add(new Node(k,i,j));
                    }
                }
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

                for(int i=0; i < nodes.length;i++){
                    int nx = nowNode.x + nodes[i].x;
                    int ny = nowNode.y + nodes[i].y;
                    int nz = nowNode.z + nodes[i].z;

                    if(nx>=0 && nx < M && ny >= 0 && ny < N && nz >=0 && nz < H
                            && tomato[nz][ny][nx] == 0){
                        q1.add(new Node(nz,ny,nx));
                        tomato[nz][ny][nx] = 1;
                    }
                }
            }
                cnt++;
        }

        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(tomato[k][i][j] == 0){
                        cnt = 0;
                    }
                }
            }
        }

        System.out.println(cnt-1);
    }
}
