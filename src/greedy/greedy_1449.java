package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class greedy_1449 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int [] arr = new int[N];

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int tapeRange = 0;
        int tapeCount = 0;

        for(int i=0; i<N; i++){
            if (arr[i] <= tapeRange && arr[i] >= tapeRange - L){
                continue;
            }
            else{
                tapeRange = arr[i] + L - 1;
                tapeCount += 1;
            }
        }

        System.out.println(tapeCount);

    }
}
