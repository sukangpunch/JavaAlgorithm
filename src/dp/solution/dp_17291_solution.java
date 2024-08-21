package dp.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_17291_solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[]years = new int[N+1];
        years[0] = 1; years[1] = 1;

        for(int i=2;i <= N; i++){
            years[i] = years[i-1] * 2;

            if(i > 3 && i % 2 == 0) years[i] -= years[i-4];
            if(i > 4 && i % 2 == 0) years[i] -= years[i-5];
        }
        System.out.println(years[N]);
    }
}
