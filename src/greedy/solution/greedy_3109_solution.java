package greedy.solution;

import java.io.*;

public class greedy_3109_solution {

    static int[] dCol = new int[]{-1, 0, 1};
    static int R;
    static int C;

    static char[][] map;

    static boolean Dfs(int x, int y){
        if(y == C - 1){
            return true;
        }

        for(int i=0; i<3;i++){
            int nx = x + dCol[i];
            int ny = y + 1;

            if(nx < 0 || nx >= R || ny >= C || map[nx][ny] == 'x'){
                continue;
            }

            map[nx][ny] = 'x';

            //선택지 1, 2, 3번을 다 확인해 봐야 하는데, 그냥 return Dfs(nx,ny)를 하게 되면, 1번에서 에러가 발생 한 경우 2, 3번에 대한 가능성을 체크하지 못함
            if(Dfs(nx, ny)) return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);

        map = new char[R][C];

        for(int i=0; i<R; i++){
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        int cnt = 0;

        for(int i=0; i<R; i++){
            if(Dfs(i,0)){
                cnt++;
            }
        }

        bw.write(cnt+"\n");
        bw.flush();
        br.close();
    }
}
