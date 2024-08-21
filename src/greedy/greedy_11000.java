package greedy;

import java.io.*;
import java.util.*;

public class greedy_11000 {
    public static class Class{
        int startTime;
        int endTime;

        public Class(int start, int end){
            this.startTime = start;
            this.endTime = end;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Class arr[] = new Class[N];

        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Class(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, (l1, l2) -> l1.startTime == l2.startTime ? l1.endTime - l2.endTime : l1.startTime - l2.startTime);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0].endTime);

        for(int i= 1; i< N; i++){
            if(pq.peek() <= arr[i].startTime){
                pq.poll();
            }
            pq.offer(arr[i].endTime);
        }

        bw.write(pq.size()+"\n");
        bw.close();
        br.close();
    }
}
