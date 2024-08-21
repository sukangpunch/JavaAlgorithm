package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class implement_6996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            char [] arr1 = str1.toCharArray();
            char [] arr2 = str2.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            if(Arrays.equals(arr1,arr2)){
                sb.append(String.format("%s & %s are anagrams.", str1, str2)).append("\n");
            }else{
                sb.append(String.format("%s & %s are NOT anagrams.", str1, str2)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
