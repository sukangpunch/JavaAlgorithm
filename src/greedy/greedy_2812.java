package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class greedy_2812 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        List<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            arr.add(str.charAt(i) - '0');
        }

        for(int i=0; i<K; i++){
            int maxIndex = 0;
            int max = makeNum(0,arr);
            for(int j=1; j < arr.size(); j++){
                if(arr.size() -1 != j && arr.get(j+1) == 0)continue;
                int num = makeNum(j,arr);
                if(num > max){
                    max = num;
                    maxIndex = j;
                }
            }
            arr.remove(maxIndex);
        }

        System.out.println(makeNum(-1, arr));
    }

    public static int makeNum(int index, List<Integer> list){
        sb = new StringBuilder();
        int result = 0;

        if(index == -1){
            for(int i=0; i<list.size();i++){
                sb.append(list.get(i));
            }
            result = Integer.parseInt(sb.toString());
        }
        else
        {
            int tmp = list.remove(index);
            for(int i=0; i<list.size();i++){
                sb.append(list.get(i));
            }

            result = Integer.parseInt(sb.toString());
            list.add(index,tmp);
        }

        return result;
    }
}
