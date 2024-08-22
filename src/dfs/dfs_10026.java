package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class dfs_10026 {

    static class Node{
        int x;
        int y;

        public Node(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
    static char[][] picture;
    static boolean[][] visited;
    static boolean[][] blindVisited;
    static Node[] nodes;
    static int N;
    static int result;
    static int blindResult;
    static Queue<Node> q = new LinkedList<>();

    static void bfs(Node node, int check){
        q.add(node);

        while(!q.isEmpty()){
            Node point = q.poll();
            visited[point.y][point.x] = true;
            char c = picture[point.y][point.x];
            for(int i=0; i<4; i++){
                int nx = point.x + nodes[i].x;
                int ny = point.y + nodes[i].y;

                if(check == 1){
                    if(nx>=0 && nx < N && ny >=0 && ny<N &&
                            !visited[ny][nx] && picture[ny][nx] == c){
                        q.add(new Node(ny,nx));
                    }
                }else{
                    if(nx>=0 && nx < N && ny >=0 && ny<N && !visited[ny][nx]){
                        if(picture[ny][nx] == c || (picture[ny][nx]=='R' && c == 'G') || (picture[ny][nx]=='G' && c == 'R')){
                            q.add(new Node(ny,nx));
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];
        visited = new boolean[N][N];
        blindVisited = new boolean[N][N];

        nodes = new Node[]{new Node(-1,0), new Node(1,0),
                new Node(0, -1), new Node(0,1)};

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                picture[i][j] = input.charAt(j);
            }
        }

        for(int i=0; i<N;i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    result++;
                    bfs(new Node(i,j),1);
                }
            }
        }
        visited = new boolean[N][N];

        for(int i=0; i<N;i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    blindResult++;
                    bfs(new Node(i,j),0);
                }
            }
        }

        System.out.print(result + " " + blindResult);
    }
}
