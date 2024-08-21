package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bf_1018 {
    static boolean[][] chess;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        chess = new boolean[N][M];

        for(int i = 0; i<N; i++){
            String [] str = br.readLine().split("");
            for(int j =0; j<M; j++){
                if(str[j].equals("W")){
                    chess[i][j] = true;
                }else{
                    chess[i][j] = false;
                }
            }
        }

        for(int r=0; r < N - 7; r++){
            for(int c=0; c < M - 7; c++){
                find(r,c);
            }
        }
        System.out.println(min);
    }

    static void find(int x, int y){
        int cnt =0;
        int end_x = x+8;
        int end_y = y+8;

        boolean TF = chess[x][y];

        for(int i=x; i<end_x; i++){
            for(int j=y; j<end_y; j++){

                if(chess[i][j] != TF){
                    cnt++;
                }

                TF = (!TF);
            }
            TF = !TF;
        }

        cnt = Math.min(cnt, 64 - cnt);
        min = Math.min(cnt, min);
    }
}
