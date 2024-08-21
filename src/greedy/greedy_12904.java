package greedy;

import java.io.*;
import java.util.*;

public class greedy_12904 {

    public static boolean checkStr(String s, List<Character> t){
        StringBuilder sb = new StringBuilder();
        for(Character ch : t){
            sb.append(ch);
        }
        String joinString = sb.toString();

        if(s.equals(joinString)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String T = br.readLine();
        List<Character> l = new ArrayList<>();
        int check = 0;

        for(int i=0; i<T.length(); i++){
            l.add(T.charAt(i));
        }

        for(int i=T.length(); i>0; i--){
            if(l.get(l.size()-1) == 'A'){
                l.remove(l.size()-1);
                if(checkStr(S, l)){
                  check = 1;
                }
            }
            else if (l.get(l.size() - 1) == 'B'){
                l.remove(l.size()-1);
                Collections.reverse(l);
                if(checkStr(S, l)){
                    check = 1;
                }
            }
        }

        bw.write(check + "\n");
        br.close();
        bw.close();
    }
}
