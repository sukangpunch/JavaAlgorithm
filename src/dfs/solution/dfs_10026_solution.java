package dfs.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dfs_10026_solution {

    static int N;
    static String S;
    static char[][] picture;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    static void dfs(int y, int x){
        visited[y][x] = true;
        char ch = picture[y][x];
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N
                    && !visited[ny][nx] && picture[ny][nx] == ch){
                dfs(ny,nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        picture = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i<N ; i++){
            S = br.readLine();
            for(int j=0; j<N; j++){
                picture[i][j] = S.charAt(j);
            }
        }

        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N ; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }

        int blindCnt = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (picture[i][j] == 'G') {
                    picture[i][j] = 'R'; // G를 R로 바꿔준다.
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    blindCnt++;
                }
            }
        }

        System.out.println(cnt + " " + blindCnt);
    }
}
