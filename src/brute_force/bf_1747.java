package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bf_1747 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        if(N == 1){result = 2;}

        while(N != 1){
            if(checkPrime(N)){
                if(checkPelin(N)){
                    result = N;
                    break;
                }
            }
            N++;
        }
        System.out.println(result);
    }

    static boolean checkPelin(int num){
        String n = Integer.toString(num);
        int size = n.length();

        for(int i = 0; i < size/2; i++){
            if(n.charAt(i) != n.charAt(size-1-i)){
                return false;
            }
        }
        return true;
    }
    static boolean checkPrime(int num){
        int n = (int)Math.sqrt(num);

        for(int i=2; i<=n; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
