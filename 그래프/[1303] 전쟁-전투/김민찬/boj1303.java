import java.util.*;
import java.io.*;

public class boj1303 {
    
    static boolean[][] visitedW;
    static boolean[][] visitedB;
    static String[][] war;

    static int[] dy ={-1,0,1,0};
    static int[] dx ={0,1,0,-1};

    static int n;
    static int m;
    static int sumW=0;
    static int sumB=0;

    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken()); // 층
        //System.out.println(m);

        war= new String[m][n];

        for(int i=0; i<m; i++){
            war[i]=br.readLine().split("");
        }                                 

        visitedW = new boolean[m][n];
        visitedB = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                BFS(i,j);
            }
        }

        System.out.print(sumW+" "+sumB);
        
    }

    public static void BFS(int y, int x){
        Queue<Integer> q = new LinkedList<>();
        int cnt=1;
        if(war[y][x].equals("W") && visitedW[y][x]==false){
            q.add(y);
            q.add(x);
            visitedW[y][x]=true;
            while(!q.isEmpty()){
                int nowY = q.poll();
                int nowX = q.poll();
                for(int i=0;i<4; i++){
                    int nextY = nowY+dy[i];
                    int nextX = nowX+dx[i];
                    if(!check(nextY,nextX)) continue;
                    if(visitedW[nextY][nextX]==false&&war[nextY][nextX].equals("W") ){
                        visitedW[nextY][nextX]=true;
                        q.add(nextY);
                        q.add(nextX);
                        cnt++;
                        //System.out.println("W : " + cnt);
                    }

                }
            }
            
            sumW+=cnt*cnt;
            
        }
        else if(war[y][x].equals("B") && visitedB[y][x]==false){
            q.add(y);
            q.add(x);
            visitedB[y][x]=true;
            while(!q.isEmpty()){
                int nowY = q.poll();
                int nowX = q.poll();
                for(int i=0;i<4; i++){
                    int nextY = nowY+dy[i];
                    int nextX = nowX+dx[i];
                    if(!check(nextY,nextX)) continue;
                    if(visitedB[nextY][nextX]==false && war[nextY][nextX].equals("B")){
                        visitedB[nextY][nextX]=true;
                        q.add(nextY);
                        q.add(nextX);
                        cnt++;
                        //System.out.println("B : " + cnt);
                    }
                    
                }
            }
            sumB+=cnt*cnt;
        }
        
    }

    public static boolean check(int y, int x){
        // 범위 밖이면 false반환
        if(y<0 || x<0 || m<=y || n<=x) return false;
        return true;
    }
    
}





