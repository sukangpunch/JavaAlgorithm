package brute_force;

import java.io.*;

public class bf_4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            long num = Long.parseLong(br.readLine());
            if(num == 0 || num == 1){
                sb.append(2+"\n");
                continue;
            }
            sb.append(checkPelin(num) + "\n");
        }

        bw.write(sb+"");
        bw.flush();
        br.close();
    }

    static long checkPelin(long num){
        long n = num;

        while(true){
            boolean flag = true;
            long nq = (long) Math.sqrt(n);
            for(long i=2; i <= nq; i++){
                if(n % i == 0){
                    flag = false;
                    break;
                }
            }
            if(!flag)n++;
            else{
                return n;
            }

        }
    }
}
