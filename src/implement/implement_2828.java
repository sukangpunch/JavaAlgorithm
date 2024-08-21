package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int j = Integer.parseInt(br.readLine());

        Integer [] arr = new Integer[j];

        for (int i = 0; i < j ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int now = m;
        int cnt = 0;

        for(int i = 0; i < j; i++)
        {
            if (arr[i] > now){
                int move = arr[i] - now;
                cnt += move;
                now += move;
            }
            else if(arr[i] < now - m + 1){
                int move = now - m+1 - arr[i];
                cnt += move;
                now -= move;
            }

        }
        System.out.println(cnt);
    }
}
