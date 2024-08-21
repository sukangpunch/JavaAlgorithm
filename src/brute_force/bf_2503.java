package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bf_2503 {
    static boolean[] check = new boolean[988];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=123; i<=987; i++){
            String num = String.valueOf(i);
            if(num.charAt(0) == '0' || num.charAt(1) == '0' || num.charAt(2) == '0')continue;
            if(num.charAt(0) == num.charAt(1) || num.charAt(0) == num.charAt(2) || num.charAt(1) == num.charAt(2))continue;
            check[i] = true;
        }

        for(int i=0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            for(int a = 123; a <= 987; a++){
                if(check[a]){
                    int sn = 0;
                    int bn = 0;

                    for(int one = 0; one < 3; one++){
                        char num_split = Integer.toString(number).charAt(one);

                        for(int two = 0; two < 3; two++){
                            char a_split = Integer.toString(a).charAt(two);
                            if(num_split == a_split && one == two)sn++;
                            else if(num_split == a_split && one !=two)bn++;
                        }
                    }

                    if(sn == S && bn == B)check[a] = true;
                    else check[a] = false;
                }
            }
        }
        int a = 0;

        for(int i=123; i<=987; i++){
            if(check[i])a++;
        }

        System.out.println(a);
    }
}
