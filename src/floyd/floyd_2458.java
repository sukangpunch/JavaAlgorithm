package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class floyd_2458 {

    static boolean [][] matrix;
    static int [] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        matrix = new boolean[N+1][N+1];
        visited = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            matrix[s][e] = true;
        }
        for(int k=1; k<= N; k++){
            for(int i=1; i <= N; i++){
                for(int j = 1; j<=N; j++){
                    if(matrix[i][k] && matrix[k][j]){
                        matrix[i][j] = true;
                    }
                }
            }
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(matrix[i][j] || matrix[j][i]){
                    visited[i]++;
                }
            }
        }

        int result = 0;
        for(int num : visited){
            if(num == N-1) result++;
        }
        System.out.println(result);
    }
}
