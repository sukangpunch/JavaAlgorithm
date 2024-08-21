package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_17291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[]years = new int[N+1];
        int[] born = new int[N+1];
        years[1] = 1;
        born[1] = 1;


        for(int i = 2; i<=N;i++){
            if(i == 2 || i== 3){
                years[i] = years[i-1] * 2;
                born[i] = years[i] - years[i-1];
            }else if(i==4){
                years[i] = years[i-1] * 2 - born[i-3];
                born[i] = 4;
            }
            else if(i % 2 !=0){
                born[i] = years[i-1];
                years[i] = years[i-1] * 2;
            }
            else if(i % 2 == 0){
                born[i] = years[i-1];
                years[i] = years[i-1]*2 - (born[i-3] + born[i-4]);
            }
        }

        System.out.println(years[N]);

    }
}
