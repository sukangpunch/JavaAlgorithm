package data_structure.solution;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class ds_28279_solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String answer = br.readLine();

            if(answer.length() == 1){
                int answerCode = Integer.parseInt(answer);
                switch (answerCode){
                    case 3: sb.append((dq.isEmpty() ? -1 : dq.pollFirst()) + "\n");break;
                    case 4: sb.append((dq.isEmpty() ? -1 : dq.pollLast()) + "\n");break;
                    case 5: sb.append(dq.size()+"\n");break;
                    case 6: sb.append((dq.isEmpty() ? 1 : 0) + "\n"); break;
                    case 7: sb.append((dq.isEmpty() ? -1 : dq.peekFirst()) + "\n");break;
                    case 8: sb.append((dq.isEmpty() ? -1 : dq.peekLast()) + "\n");break;
                }
            }else{
                StringTokenizer st = new StringTokenizer(answer," ");
                String answerCode = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if(answerCode.equals("1")){
                    dq.offerFirst(value);
                }
                else{
                    dq.offerLast(value);
                }
            }
        }

        /* 이것떄문에 계속 틀렸다 그랬다. "\n" 을 추가하면 틀렸다고 함 */
        bw.write(sb+"");
        br.close();
        bw.flush();
    }
}
