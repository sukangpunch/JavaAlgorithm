package data_structure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ds_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        List<Character> result = new ArrayList<>();
        for(int i=0; i<str.length(); i++){result.add(str.charAt(i));}

        int N = Integer.parseInt(br.readLine());
        int cursor = str.length();

        for(int i=0; i<N;i++){
            String tmp = br.readLine();

            switch (tmp.charAt(0)){
                case 'L': cursor = cursor == 0 ? 0 : cursor - 1;break;
                case 'D': cursor = cursor == result.size() ? result.size() : cursor + 1; break;
                case 'B': if(cursor==0 || result.isEmpty())break;else result.remove(--cursor);break;
                case 'P': result.add(cursor++, tmp.charAt(2));break;
            }
        }

        for(Character c : result){
            sb.append(c);
        }

        bw.write(sb+"");
        bw.flush();
        br.close();

    }
}
