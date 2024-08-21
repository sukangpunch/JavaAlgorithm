package data_structure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ds_28279 {
    static class Deque{
        static List<Integer> dq;

        public Deque(){
            dq = new ArrayList<>();
        }

        void pushStart(int x){
            dq.add(0, x);
        }

        void pushEnd(int x){
            dq.add(x);
        }

        int popStart(){
            if(dq.isEmpty()){
                return -1;
            }
            return dq.remove(0);
        }

        int popEnd(){
            if(dq.isEmpty()){
                return -1;
            }
            return dq.remove(dq.size()-1);
        }

        int dqSize(){
            return dq.size();
        }

        int isDqEmpty(){
            if(dq.isEmpty()){
                return 1;
            }else{
                return 0;
            }
        }

        int peekStart(){
            if(dq.isEmpty()){
                return -1;
            }
            else{
                return dq.get(0);
            }
        }

        int peekEnd(){
            if(dq.isEmpty()){
                return -1;
            }else{
                return dq.get(dq.size()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque dq = new Deque();

        for(int i=0; i<N; i++){
            String answer = br.readLine();
            if(answer.length()==1){
                switch (answer){
                    case "3": sb.append(dq.popStart()+"\n");break;
                    case "4": sb.append(dq.popEnd()+"\n");break;
                    case "5": sb.append(dq.dqSize()+"\n");break;
                    case "6": sb.append(dq.isDqEmpty()+"\n");break;
                    case "7": sb.append(dq.peekStart()+"\n");break;
                    case "8": sb.append(dq.peekEnd() +"\n");break;
                }
            }
            else{
                StringTokenizer st = new StringTokenizer(answer," ");
                String answerCode = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if(answerCode.equals("1")){
                    dq.pushStart(value);
                }else{
                    dq.pushEnd(value);
                }
            }
        }
        bw.write(sb+"\n");
        br.close();
        bw.flush();
    }

}
