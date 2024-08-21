package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greedy_2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        String A = st.nextToken();
        String B = st.nextToken();
        String minA = "";
        String maxA = "";
        String minB = "";
        String maxB = "";

        int min = 0;
        int max = 0;

        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '6'){
                minA += '5';
                maxA += A.charAt(i);
            }
            else if(A.charAt(i) == '5'){
                maxA += '6';
                minA += A.charAt(i);
            }
            else{
                maxA += A.charAt(i);
                minA += A.charAt(i);
            }
        }

        for(int i=0; i<B.length();i++){
            if(B.charAt(i) == '6'){
                minB += '5';
                maxB += B.charAt(i);
            }
            else if(B.charAt(i) == '5'){
                maxB += '6';
                minB += B.charAt(i);
            }
            else{
                maxB += B.charAt(i);
                minB += B.charAt(i);
            }
        }

        min = Integer.parseInt(minA) + Integer.parseInt(minB);
        max = Integer.parseInt(maxA) + Integer.parseInt(maxB);

        System.out.println(String.valueOf(min)+" "+String.valueOf(max));

    }
}
