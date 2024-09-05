package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pfs_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int [] arr =  new int[N];
        int [] arr2 = new int[N];
        st = new StringTokenizer(br.readLine());
        int tmp = Integer.parseInt(st.nextToken());
        arr[0] = tmp;
        arr2[0] = tmp;

        for(int i = 1; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n+arr[i-1];
            arr2[i] = n;
        }

        int min = 987654321;
        int s = 0;
        int e = 0;

        while(e<N){
            while(s < N && S <= arr[e] - arr[s] + arr2[s]){
                if(min > e - s + 1)min = e - s + 1;
                s++;
            }
            e++;
        }
        min = min == 987654321 ? 0 : min;

        System.out.println(min);
    }
}
