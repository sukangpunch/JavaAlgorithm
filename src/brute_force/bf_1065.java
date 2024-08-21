package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bf_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for(int i=1; i<=N; i++){
            boolean flag = true;
            String num = Integer.toString(i);
            if(num.length()<3){
                result++;
                continue;
            }
            else{
                int gap = (num.charAt(0)- '0') - (num.charAt(1)-'0');
                for(int j=1; j<num.length()-1;j++){
                    int tmp = (num.charAt(j)- '0') - (num.charAt(j+1)-'0');
                    if(tmp != gap){
                        flag = false;
                    }
                }

                if(flag){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
