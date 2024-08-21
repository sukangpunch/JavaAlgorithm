package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bf_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] cards = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }


        int result = 0;
        for(int i=0; i<N-2;i++){
            for(int j=i+1; j<N-1;j++){
                for(int k=j+1; k<N; k++){
                    int tmp = cards[i] + cards[j] + cards[k];
                    if(tmp <=M){
                        if(M-tmp < M - result){
                            result = tmp;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
