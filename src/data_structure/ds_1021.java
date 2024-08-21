package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ds_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        Deque<Integer> q = new ArrayDeque<>();


        for(int i=1; i<N+1; i++){
            q.add(i);
        }

        str = br.readLine().split(" ");
        int cnt = 0;

        for(int i=0; i<M; i++){
            int index = 0;
            int targetIndex = -1;
            int targetKey = Integer.parseInt(str[i]);
            for(Integer element : q){
                if(element.equals(targetKey)){
                    targetIndex = index;
                    break;
                }
                index++;
            }
            while(true){
                if(targetKey == q.peekFirst()){
                    q.pollFirst();
                    break;
                }
                else if(q.size()/2 >= targetIndex){
                    cnt++;
                    int tmp = q.pollFirst();
                    q.offerLast(tmp);
                }
                else{
                    cnt++;
                    int tmp = q.pollLast();
                    q.offerFirst(tmp);
                }
            }
        }
        System.out.println(cnt);
    }
}
