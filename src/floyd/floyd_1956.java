package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class floyd_1956 {

    static int V;
    static int E;

    static int [][] city;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int max = (V+1) * 10000;      //유동적으로 크기 정하기

        city = new int[V+1][V+1];

        for(int i=1; i<=V;i++){
            for(int j=1; j<=V; j++)
            {
                if(i == j){
                    city[i][j] = 0;
                }
                else{
                    city[i][j] = max;
                }
            }
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            city[a][b] = c;               //단방향 && 한 정점에서 다른 정점으로 가는 경우는 단 하나의 길만 존재
        }

        for(int k=1; k<= V; k++){
            for(int i = 1; i<=V; i++){
                for(int j = 1; j<=V; j++){
                    city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
                }
            }
        }
        result = max;

        for(int i=1; i<=V;i++){
            for(int j=1; j<=V; j++){
                if(city[i][j] != max && city[i][j] != 0
                        && city[j][i] != max && city[j][i] != 0){           //floyd 알고리즘 이후, 가는길 and 돌아오는 길이 있으면 사이클이 형성된다.
                    int tmp = city[i][j] + city[j][i];
                    if(result > tmp){
                        result = tmp;
                    }
                }
            }
        }
        if(result == max) {
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
}
