package greedy.solution;

import java.io.*;
import java.util.Stack;

public class greedy_2812_solution{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String [] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        String s = br.readLine();

        Stack<Character> st = new Stack<>();
        int cnt = 0;

        for(int i=0; i< s.length(); i++){
            while(!st.isEmpty() && cnt < K && st.peek() < s.charAt(i)){
                st.pop();
                cnt++;
            }

            if(st.size() < N - K){
                st.add(s.charAt(i));
            }
        }

        for(int i=0; i<st.size(); i++){
            sb.append(st.get(i));
        }

        bw.write(sb+ "\n");
        br.close();
        bw.flush();
    }
}
