package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class greedy_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),".",true);

        List<String> xList = new ArrayList<>();

        while(st.hasMoreTokens()){
            xList.add(st.nextToken());
        }

        String result = "";

        for(int i=0; i<xList.size();i++)
        {
            String x = xList.get(i);
            int strSize = x.length();

            if(x.equals(".")){
                result += ".";
            }
            else if(strSize % 2 != 0){
                result = "-1";
                break;
            }
            else{
                while(strSize !=0){
                    if(strSize >= 4){
                        result += "AAAA";
                        strSize -= 4;
                    }
                    else if(strSize >= 2){
                        result += "BB";
                        strSize -= 2;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
