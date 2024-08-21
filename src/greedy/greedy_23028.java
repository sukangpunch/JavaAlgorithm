package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greedy_23028 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int check = 0;


        for (int i=0; i<8-N; i++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int major = Integer.parseInt(st2.nextToken());
            int general = Integer.parseInt(st2.nextToken());
            int size = 0;

            if(major <= 6){
                int tmp = major*3;
                A += tmp;
                B += tmp;
                size += tmp;
            }
            else{
                A += 6*3;
                B += 6*3;
                continue;
            }

            if(general*3 - (18-size) > 0){
                B += 18-size;
            }
            else{
                B += general*3;
            }

            if(A>= 66 && B>= 130){
                check = 1;
                break;
            }
        }

        if(check==1){
            System.out.println("Nice");
        }
        else{
            System.out.println("Nae ga wae");
        }

    }
}
