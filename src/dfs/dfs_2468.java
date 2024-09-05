package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dfs_2468 {

    static int [][] map;
    static boolean [][] visited;
    static int N;

    static int[] nodeX = {1,0,0,-1};
    static int[] nodeY = {0,1,-1,0};
    static int result;

    static void dfs(int start, int end){
        visited[start][end] = true;

        for(int i=0; i<4; i++){
            int nx = end + nodeX[i];
            int ny = start + nodeY[i];

            if(nx>=0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx]){
                dfs(ny,nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int maxHeight = 0;
        int maxArea = 0;

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String []input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                if(maxHeight < Integer.parseInt(input[j])){
                    maxHeight = Integer.parseInt(input[j]);
                }
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int k=0; k<=maxHeight; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] <= k){
                        visited[i][j] = true;
                    }else{
                        visited[i][j] = false;
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        dfs(i, j);
                        result++;
                    }
                }
            }
            if(maxArea < result){
                maxArea = result;
            }
            result = 0;
        }

        System.out.println(maxArea);
    }
}
