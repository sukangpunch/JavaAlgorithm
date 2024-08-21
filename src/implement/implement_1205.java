package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        if (n==0){
            System.out.println(1);
            return;
        }

        int new_point = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");

        for(int i =0; i<n ; i++)
        {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int ranking = 1;

        if(arr.length == p && new_point <= arr[arr.length-1]) {
            System.out.println(-1);
            return;
        }

        for(int i=0; i < n; i++){
            if(new_point >= arr[i]){
                ranking = i + 1;
                break;
            }
            else{
                ranking++;
            }
        }

        if(ranking <= p){
            System.out.println(ranking);
        }
        else{
            System.out.println(-1);
        }
    }
}
