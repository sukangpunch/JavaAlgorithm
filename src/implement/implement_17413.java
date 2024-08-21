package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class implement_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        String str = br.readLine();

        for(int i = 0; i < str.length();i++){
           char ch = str.charAt(i);
            if(ch == '<'){
                while(!stk.empty())
                {
                    sb.append(stk.pop());
                }
                stk.push(str.charAt(i));
                sb.append("<");
           }
           else if(ch == '>')
           {
               stk.pop();
               sb.append(">");
           }
           else if(!stk.empty() && stk.peek() == '<')
           {
               sb.append(str.charAt(i));
           }
           else if(Character.isWhitespace(ch))
           {
               while(!stk.empty())
               {
                   sb.append(stk.pop());
               }
               sb.append(" ");
           }
           else{
               stk.push(ch);
            }
        }

        while(!stk.empty())
        {
            sb.append(stk.pop());
        }

        System.out.println(sb);






    }
}
