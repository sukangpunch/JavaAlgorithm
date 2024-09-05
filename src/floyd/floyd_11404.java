package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class floyd_11404 {
    static int [][] matrix;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        matrix = new int[n+1][n+1];
        int max = 100000*n;

        for(int i=1; i<=n;i++){
            for(int j=1; j<=n; j++)
            {
                if(i == j)matrix[i][j] = 0;
                else matrix[i][j] = max;
            }
        }
        for(int i = 0; i < m ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            matrix[s][e] = Math.min(matrix[s][e], w);
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                if (i == k) continue;
                for(int j = 1; j <= n; j++){
                    if (j == k || i == j) continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for(int i=1; i<=n;i++){
            for(int j=1; j<=n; j++)
            {
                if(matrix[i][j] == max) matrix[i][j] = 0;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
