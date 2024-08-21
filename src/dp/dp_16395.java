package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class dp_16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int[] arr;
        List<int[]> pascal = new ArrayList<>();

        for(int i=0; i<n;i++){
            arr = new int[n-i];
            for(int j=0;j < n-i;j++){
                if(i == 0 || j == 0){
                    arr[j] = 1;
                }
                else{
                    int [] tmp = pascal.get(i-1);
                    arr[j] = arr[j-1] + tmp[j];
                }
            }
            pascal.add(arr);
        }

        int result = pascal.get(n-k)[k-1];
        System.out.println(result);

    }
}
