package data_structure.solution;

import java.io.*;
import java.util.Stack;

public class ds_1406_solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            leftStack.push(str.charAt(i));
        }
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String input = br.readLine();
            switch (input.charAt(0)){
                case 'L': if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());break;
                case 'D': if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());break;
                case 'B': if(!leftStack.isEmpty()) leftStack.pop();break;
                case 'P': leftStack.push(input.charAt(2));break;
            }
        }

        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }

        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }

        bw.write(sb+"");
        br.close();
        bw.flush();
    }
}
