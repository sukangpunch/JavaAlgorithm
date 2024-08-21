package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greedy_1080 {
    private static int[][] m1;
    private static int[][] m2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        m1 = new int[N][M];
        m2 = new int[N][M];

        for(int i =0; i<N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                m1[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i =0; i<N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                m2[i][j] = line.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for(int i=0; i < N - 2; i++){
            for(int j=0; j < M - 2; j++){
                if(m1[i][j] != m2[i][j]){
                    changeMatrix(i,j);
                    cnt++;
                }
            }
        }

        if(isSame(N, M)){
            System.out.println(cnt);
        }else{
            System.out.println(-1);
        }
    }

    private static boolean isSame(int N, int M){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(m1[i][j] != m2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static void changeMatrix(int startY, int startX){
        for(int i= startY; i<startY + 3;i++){
            for(int j= startX; j <startX + 3; j++){
                m1[i][j] = m1[i][j] == 0 ? 1 : 0;
            }
        }
    }
}
