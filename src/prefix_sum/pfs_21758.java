package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pfs_21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int []honey = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++){
            honey[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for(int k=0; k<N; k++)
        {
            for(int i = 0; i<N-1; i++){
                if(i==k)continue;
                for(int j = i+1; j<N;j++){
                    int tmp = 0;
                    if(i < k && j < k){
                        for(int z = i+1; z<=k; z++){
                            if(j==z)continue;
                            tmp += honey[z];
                        }
                        for(int z = j+1; z<=k; z++){
                            tmp += honey[z];
                        }
                    }else if(i > k && j > k){
                        for(int z = j-1; z>=k; z--){
                            if(i==z)continue;
                            tmp += honey[z];
                        }
                        for(int z = i-1; z>=k; z--){
                            tmp += honey[z];
                        }
                    }else{
                        for(int z = i+1; z<=k;z++){
                            tmp += honey[z];
                        }
                        for(int z = j-1; z>=k; z--){
                            tmp += honey[z];
                        }
                    }
                    if(result < tmp){
                        result = tmp;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
