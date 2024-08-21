package data_structure;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class ds_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<int[]> dq = new ArrayDeque<>();
        String []str = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            int [] item = {i+1, Integer.parseInt(str[i])};
            dq.add(item);
        }


        for(int i=0; i<N; i++){
            int [] item = dq.pollFirst();
            sb.append(item[0]+" ");

            if(dq.isEmpty()){break;}
            if(item[1] <0){
                for(int j=0; j < -(item[1]); j++){
                    int[] tmp = dq.pollLast();
                    dq.offerFirst(tmp);
                }
            }
            else{
                for(int j=0; j < item[1] - 1; j++){
                    int[] tmp = dq.pollFirst();
                    dq.offerLast(tmp);
                }
            }

        }

        bw.write(sb+"\n");
        br.close();
        bw.flush();
    }
}
