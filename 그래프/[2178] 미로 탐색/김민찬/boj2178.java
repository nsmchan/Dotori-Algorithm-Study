import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj2178 {

    // 상하좌우를 탐색하기 위한 배열 선언하기
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited; // 방문배열
    static int[][] maze;
    static int n,m;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args)throws IOException{
        br= new BufferedReader(new InputStreamReader(System.in));
        bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        maze = new int[n][m];
        // 미로 만들기
        for(int i=0;i<n;i++){

            String line =br.readLine();
            for(int j=0;j<m;j++){
                maze[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0,0);
        bw.write(maze[n-1][m-1]+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void BFS(int i, int j){

        // Queue
        Queue<int[]> q = new LinkedList<>();
        // y,x 좌표가 큐 들어간다
        q.add(new int[] {i,j});
        visited[i][j]=true;
        while(!q.isEmpty()){
            int now[] = q.poll();
            // 4방향에 대해서 검사하기
            for(int k=0;k<4;k++){
                int y = now[0]+dy[k];
                int x = now[1]+dx[k];
                if(y >=0 && x>=0 && y <n && x<m){ // 좌표 유효성
                    if(maze[y][x] !=0 && visited[y][x]==false){
                        visited[y][x]=true;
                        maze[y][x]=maze[now[0]][now[1]]+1; // 도착지에 값 적기
                        q.add(new int[] {y,x});
                    }
                }
            }
        }
    }
    
}
