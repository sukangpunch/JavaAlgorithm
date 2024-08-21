package dp;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class dp_9711 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int [] pbSize = new int[n];
        BigInteger [] divide = new BigInteger[n];

        for(int i=0; i<n; i++){
            String []str = br.readLine().split(" ");
            pbSize[i] = Integer.parseInt(str[0]);
            divide[i] = new BigInteger(str[1]);
        }

        int maxPdSize = Arrays.stream(pbSize).max().getAsInt();
        BigInteger []pb = new BigInteger[maxPdSize+1];

        pb[0] = new BigInteger("0");
        pb[1] = new BigInteger("1");

        for(int i=2; i<=maxPdSize; i++){
            pb[i] = pb[i-2].add(pb[i-1]);
        }

        for(int i=0; i<n;i++){
            BigInteger result = pb[pbSize[i]].remainder(divide[i]);
            sb.append(String.format("Case #%d: ",i+1) + result +"\n");
        }

        bw.write(sb+"\n");
        br.close();
        bw.flush();
    }
}
