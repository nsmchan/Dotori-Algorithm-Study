import java.util.*;
import java.io.*;

// 2:02 시작 
public class boj14502 {
    
    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};
    static int n;
    static int m;

    static boolean[][] visited;

    static int[][] lab;
    static int[][] lab2;

    static int max=0;
    static int cnt=0;

    static Queue<Integer> q2 = new LinkedList<>();
    static List<int[]> list2 = new ArrayList<>();


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        visited = new boolean[n][m];
        lab = new int[n][m];
        lab2 = new int[n][m];
       
        // lab실 만들기, 바이러스 위치 넣어두기
        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                lab[i][j]=Integer.parseInt(st.nextToken());
                // 바이러스 위치 list2에 넣어두기
                if(lab[i][j]==2){
                    int[] pos2 = {i,j};
                    list2.add(pos2);
                }
            }
        }
         // lab실 복사
        //lab2=lab; // --> 주소값을 가져오나보다...
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                lab2[i][j]=lab[i][j];
            }
        }
        

        DFS(0);
        System.out.println(max);

    }

    public static void DFS(int depth){
        if(depth==3){

            
            BFS();

            // for(int i=0;i<n;i++){
            //     for(int j=0; j<m;j++){
            //         System.out.print(lab2[i][j]+" ");
            //     }
            //     System.out.println();
            // }

 

            

            // // 다시 처음으로 되돌리기
            // for(int i=0;i<n;i++){
            //     for(int j=0;j<m;j++){
            //         lab2[i][j]=lab[i][j];
            //     }
            // }

            return;
        }
        for(int i=0;i<n;i++){
            for(int j=0; j<m;j++){
                if(lab2[i][j]==0){
                    lab2[i][j]=1;
                    DFS(depth+1);
                    lab2[i][j]=0;
                }
            }  
        }
    }

    public static void BFS(){

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                lab[i][j]=lab2[i][j];
            }
        }
        
        //q2 2위치로 채우는 코드
        visited = new boolean[n][m];
        for(int i=0;i<list2.size();i++){
            int y=list2.get(i)[0];
            int x=list2.get(i)[1];
            q2.add(y);
            q2.add(x);
            visited[y][x]=true;
        }
       
        
        while(!q2.isEmpty()){
            int nowY= q2.poll();
            int nowX= q2.poll();
            for(int i=0; i<4;i++){
                int nextY = nowY+dy[i];
                int nextX = nowX+dx[i];
                if(!check(nextY,nextX)) continue;
                if(lab[nextY][nextX]==0 && visited[nextY][nextX]==false){
                    visited[nextY][nextX]=true;
                    lab[nextY][nextX]=2;
                    q2.add(nextY);
                    q2.add(nextX);
                }
            }
        }
        // 0 개수찾고
        cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0; j<m;j++){
                if(lab[i][j]==0){
                    cnt++;
                }
            }
        }
                   
            // 최대값 저장하고
            if(cnt>max) max= cnt;

        

    }

    public static boolean check(int y, int x){
        //false
        if(y<0 || x<0 || n<=y || m<=x) return false;
        return true;
    }


    
}
