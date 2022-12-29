import java.util.*;
import java.io.*;

public class boj2573{

    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};

    static int n;
    static int m;
    static int[][] ice;
    static boolean[][] visited;
    static boolean[][] visited2;
    static int year=0;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        ice = new int[n][m];
        for(int i =0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                ice[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        
        
        // 한 덩어리의 빙산이 주어질 때,
        // 숫자 찾기 무조건 덩어리라 ㄱㅊ
        while(true){
            visited = new boolean[n][m];
            int cnt=0;
            for(int i=0; i<n;i++){
                for(int j=0;j<m;j++){
                    if(ice[i][j]!=0 && visited[i][j]==false){
                        BFS(i,j);
                        cnt++;
                    }
                }
            }
            // BFS 2번 이상 돌면 두덩이라 판단
            if(cnt>=2){
                System.out.print(year);
                return;
            }
            // 한번도 안돌면 덩이 분리 없이 0개되었다는거
            else if(cnt==0){
                System.out.print(0);
                return;
            }

            // 빙하감소
            visited = new boolean[n][m];
            BFS2();
            
            year++;
 
        }
    }

    public static void BFS2(){

        // 주변에 빙산있는 바다 추가
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(ice[i][j]==0){
                    for(int k=0;k<4;k++){
                        int nextY = i+dy[k];
                        int nextX = j+dx[k];
                        if(!check(nextY, nextX))continue;
                        if(ice[nextY][nextX]!=0 && visited[i][j]==false){
                            visited[i][j]=true;
                            q.add(i);
                            q.add(j);
                        }
                    }
                }
            }
        }
        

        while(!q.isEmpty()){
            int nowY = q.poll();
            int nowX = q.poll();
            for(int i=0; i<4;i++){
                int nextY = nowY+dy[i];
                int nextX = nowX+dx[i];
                if(!check(nextY, nextX))continue;
                if(ice[nextY][nextX]>0){
                    ice[nextY][nextX]--;
                }
            }
        }

    }

    public static void BFS(int y, int x){
        q.add(y);
        q.add(x);
        visited[y][x]=true;
        while(!q.isEmpty()){
            int nowY = q.poll();
            int nowX = q.poll();
            for(int i=0; i<4;i++){
                int nextY = nowY+dy[i];
                int nextX = nowX+dx[i];
                if(!check(nextY, nextX))continue;
                if(ice[nextY][nextX]!=0 && visited[nextY][nextX]==false){
                    visited[nextY][nextX]=true;
                    q.add(nextY);
                    q.add(nextX);
                }
            }
        }
    }

    public static boolean check(int y, int x){
        // 범위 밖 false
        if(y<0 || x<0  || n<=y || m<=x) return false;
        return true;
    }
}