package bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bfs_2667 {

    static class Node{
        int y;
        int x;

        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int [][]map;
    static boolean [][] visited;

    static Node [] node;

    static int dongCnt = 0;
    static int homeCnt = 0;
    static List<Integer> homeCntList;

    static int N;

    static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i=0; i<4;i++){
            Node tmp = node[i];
            int ny = y+ tmp.y;
            int nx = x+ tmp.x;

            if(ny >=0 && nx >= 0 && nx < N && ny <N && !visited[ny][nx] && map[ny][nx] == 1){
                homeCnt++;
                dfs(ny,nx);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        map = new int[N][N];
        node = new Node[]{new Node(-1, 0), new Node(1, 0), new Node(0, -1), new Node(0, 1)};
        homeCntList = new ArrayList<>();

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    dongCnt++;
                    homeCnt++;
                    dfs(i,j);
                    homeCntList.add(homeCnt);
                    homeCnt=0;
                }
            }
        }

        sb.append(dongCnt+"\n");
        Collections.sort(homeCntList);

        for(int i=0; i<homeCntList.size();i++){
            sb.append(homeCntList.get(i) + "\n");
        }

        bw.write(sb+"");
        bw.flush();
        br.close();

    }
}
