package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ds_2910 {

    static class Num{
        int first; int cnt;

        Num(int first){
            this.first= first;
            cnt = 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, Num> map = new HashMap<>();
        String arr[] = br.readLine().split(" ");

        int rank = 1;

        for(int i=0; i<N;i++){
            int num = Integer.parseInt(arr[i]);
            if(!map.containsKey(num)){
                map.put(num,new Num(rank));
                rank++;

            }else{
                map.get(num).cnt++;
            }
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((k1, k2) ->{
            int compare = map.get(k2).cnt - map.get(k1).cnt;
            if(compare == 0){
                return map.get(k1).first - map.get(k2).first;
            }
            return compare;
        });

        for(int key : keys){
            for(int i=0; i < map.get(key).cnt; i++){
                System.out.print(key + " ");
            }
        }
    }
}
