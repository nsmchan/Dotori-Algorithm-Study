import java.util.*;
import java.io.*;

// 11:00 시작
public class boj7576 {
    
    // 4방향 위부터 시계방향
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int[][] box;
    static boolean[][] visited;
    static int m=0;
    static int n=0;
    static boolean first = true;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken()); // 층

        // 박스 생성
        box = new int[n][m];
        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                box[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        // 방문 배열 
        visited= new boolean[n][m];
        BFS(0,0);
        
        int max=0;
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(box[i][j]==0){
                    System.out.println("-1");
                    return;
                }
                //System.out.print(box[i][j]);
                if(box[i][j]>max) max = box[i][j];
            }
            //System.out.println();
        }
        System.out.print(max-1);
        
        
    }

    public static void BFS(int y, int x){
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        if(box[y][x]==1){
            q2.add(0);
            q2.add(0);
        }
        q.add(0);
        q.add(0);
        // 1탐색
        while(!q.isEmpty()){
            int nowY = q.poll();
            int nowX = q.poll();
            for(int i=0;i<4;i++){
                int nextY = nowY+dy[i];
                int nextX = nowX+dx[i];
                if(!check(nextY, nextX))continue;
                if(visited[nextY][nextX]==false){
                    visited[nextY][nextX]=true;
                    if(box[nextY][nextX]==1){
                        q2.add(nextY);
                        q2.add(nextX);

                    }
                    q.add(nextY);
                    q.add(nextX);
                }
            }
        }

        visited= new boolean[n][m];
        while(!q2.isEmpty()){
            int nowY = q2.poll();
            int nowX = q2.poll();
            for(int i=0;i<4;i++){
                int nextY = nowY+dy[i];
                int nextX = nowX+dx[i];
                if(!check(nextY, nextX))continue;
                if(visited[nextY][nextX]==false && box[nextY][nextX]==0){
                    visited[nextY][nextX]=true;
                    box[nextY][nextX]=box[nowY][nowX]+1;
                    q2.add(nextY);
                    q2.add(nextX);
                }
            }
        }



    }

    public static boolean check(int y, int x){
        // 범위 밖이면 false 반환
        if(y<0 || x<0 || n<=y || m <= x) return false;
        return true;
    }
}
