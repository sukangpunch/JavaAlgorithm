package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bf_1038 {
    static List<Long> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if(N<=10) System.out.println(N);
        else if(N > 1022) System.out.println("-1");
        else{
            for(int i=0; i<10; i++){
                bp(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(N));
        }
    }

    static void bp(long num, int index){
        if(index > 10) return;
        list.add(num);
        for(int i=0; i < num % 10; i++){
            bp((num*10) + i, index + 1);
        }
    }
}
