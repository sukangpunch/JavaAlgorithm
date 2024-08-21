package data_structure;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class ds_11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        for(int i=0; i<N; i++){
            String input = br.readLine();
            if(input.equals("0")){
                int result = pq.isEmpty() ? 0 : pq.poll();
                sb.append(result+"\n");
            }
            else{
                int tmp = Integer.parseInt(input);
                pq.offer(tmp);
            }
        }

        bw.write(sb+"");
        bw.flush();
        br.close();
    }
}
