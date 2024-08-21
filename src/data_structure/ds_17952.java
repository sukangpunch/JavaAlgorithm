package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ds_17952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int time = 0;
        int score = 0;

        Stack<int[]> st = new Stack<>();
        int [] arr;

        for(int i=0; i<N; i++){
            String str = br.readLine();
            String[] subject = str.length() > 1 ? str.split(" ") : new String[]{str};

            if(time == N){
                break;
            }
            if(subject[0].equals("1")){
                arr = new int[]{Integer.parseInt(subject[1]), Integer.parseInt(subject[2])};
                if(arr[1]-1 == 0){
                    score += arr[0];
                }
                else{
                    arr[1]--;
                    st.add(arr);
                }
                time++;
            }else{
                if(!st.isEmpty()){
                    int[]current = st.pop();
                    if(current[1]-1 == 0){
                        score += current[0];
                    }
                    else{
                        current[1]--;
                        st.add(current);
                    }
                }
                time++;
            }
        }
        System.out.println(score);
    }
}
