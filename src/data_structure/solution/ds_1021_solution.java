package data_structure.solution;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ds_1021_solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();

        for(int i= 1; i<=N; i++){
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine()," ");
        int cnt=0;
        for(int i=0; i<M; i++){
            int targetIndex = deque.indexOf(Integer.parseInt(st.nextToken()));
            int half_index = deque.size()/2;

            if(targetIndex <= half_index){
                for(int j=0; j<targetIndex; j++){
                    int tmp = deque.pollFirst();
                    deque.offerLast(tmp);
                    cnt++;
                }
            }
            else{
                for(int j=0; j<deque.size() - targetIndex;j++){
                    int tmp = deque.pollLast();
                    deque.offerFirst(tmp);
                    cnt++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}
