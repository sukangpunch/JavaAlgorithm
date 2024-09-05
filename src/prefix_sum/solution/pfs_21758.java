package prefix_sum.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pfs_21758 {
    static long[] Honey;
    static int N;
    static long max;

    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Honey = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            long a = Long.parseLong(st.nextToken());
            Honey[i] = a;
        }
        max = 0;

        //벌 왼쪽 고정, 꿀통 오른쪽 고정
        long fixBeeSum = Arrays.stream(Honey).sum() - Honey[0];
        long moveBeeSum = fixBeeSum;

        for(int i = 1; i < Honey.length - 1; i++){
            long sum = fixBeeSum - Honey[i];
            moveBeeSum = moveBeeSum - Honey[i];
            sum += moveBeeSum;
            max = Math.max(sum,max);
        }

        //벌 오른쪽 고정, 꿀통 왼쪽 고정
        fixBeeSum = fixBeeSum + Honey[0] - Honey[Honey.length-1];
        moveBeeSum = fixBeeSum;
        for(int i= Honey.length -2; i>=0; i--){
            long sum = fixBeeSum - Honey[i];
            moveBeeSum = moveBeeSum - Honey[i];
            sum += moveBeeSum;
            max=Math.max(sum, max);
        }

        //벌 양쪽 고정, 꿀통 움직임
        for(int i=1; i<=Honey.length -2; i++){
            long sum = 0;
            //왼쪽 벌
            for(int j=1; j <= i; j++){
                sum += Honey[j];
            }
            //오른쪽 벌
            for(int j=Honey.length-2; j >= i; j--){
                sum += Honey[j];
            }
            max = Math.max(sum,max);
        }

        System.out.println(max);
    }
}
