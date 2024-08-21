package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class implement_1417 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n값 받고 List 생성, 배열은 다솜이를 제외한 유권자들이 들어간다.
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n-1];

        // 다솜이
        int one = Integer.parseInt(br.readLine());

        // 후보들
        for(int i = 0; i < n-1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //매수한 사람 수
        int cnt = 0;
        int check = 1;
        //one이 arr[0] 보다 작거나 같은 상황에서 수행
        while(check == 1){
            //후보가 1명일 때
            if(n == 1){cnt = 0; break;}
            check = 0;
            Arrays.sort(arr, Collections.reverseOrder());
            if(one <= arr[0])
            {
                one +=1;
                arr[0] -=1;
                cnt +=1;
                check =1;
            }

        }
        System.out.println(cnt);
    }
}
