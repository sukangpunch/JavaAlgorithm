package data_structure;

import java.io.*;
import java.util.*;

public class ds_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String [] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i=0; i<N; i++){
            String word = br.readLine();
            if(word.length()<M){
                continue;
            }

            if(!map.containsKey(word)){
                map.put(word,1);
            }
            else{
                map.put(word,map.get(word) + 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort((k1, k2)->{
            int compare = map.get(k2) - map.get(k1);
            if(compare == 0){
                if(k1.length() > k2.length()){
                    return -1;
                }
                else if(k1.length() < k2.length()){
                    return 1;
                }
                else{
                    if(k1.compareTo(k2) < 0){
                        return -1;
                    }
                    else{
                        return 1;
                    }
                }
            }
            return compare;
        });


        keySet.stream().forEach(k->{
            sb.append(k+"\n");
        });

        bw.write(sb+"");
        bw.flush();
        br.close();
    }
}
