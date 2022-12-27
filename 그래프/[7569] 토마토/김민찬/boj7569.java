import java.util.*;
import java.io.*;

public class boj7569{
    

    static int[] dy ={-1,0,1,0,0,0};
    static int[] dx ={0,1,0,-1,0,0};
    static int[] dz ={0,0,0,0,1,-1};

    static int n; // 세로
    static int m; // 가로
    static int h; // 높이

    static boolean[][][] visited;
    static int[][][] box;

    static Queue<Integer> q = new LinkedList<>();


    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());  // 가로
        n = Integer.parseInt(st.nextToken());  // 세로
        h = Integer.parseInt(st.nextToken());  // 높이

        visited = new boolean[h][n][m];  // 높이, 세로, 가로  초기화
        box = new int[h][n][m];  // 초기화

        // 상자 만들면서 1의 위치는 q 에다가 넣기
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k]==1){
                        q.add(i); // 높이
                        q.add(j); // 세로
                        q.add(k); // 가로
                    }
                }
            }
        }
        

        BFS();
        int max = 0;
        // 순회했는데 
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    // 0이 존재하면 -1 출력 
                    if(box[i][j][k]==0){
                        System.out.println("-1");
                        return;
                    }
                    if(box[i][j][k]>max){
                        max=box[i][j][k];
                    }
                }
            }
        }
        System.out.println(max-1);

        // for(int i=0;i<h;i++){
        //     for(int j=0;j<n;j++){
        //         for(int k=0;k<m;k++){
        //             System.out.print(box[i][j][k]+" ");
        //         }
        //         System.out.println();
        //     }
        // }



    }

    public static void BFS(){


        // 꺼내면서 탐색진행 
        while(!q.isEmpty()){
            int z = q.poll();
            int y = q.poll();
            int x = q.poll();

            // 방향 체크
            for(int i=0;i<6;i++){
                int newZ = z+dz[i];
                int newY = y+dy[i];
                int newX = x+dx[i];
                if(!check(newZ, newY, newX)) continue; // 범위밖이면
                if(visited[newZ][newY][newX]==false && box[newZ][newY][newX]==0){
                    visited[newZ][newY][newX]=true;
                    box[newZ][newY][newX] = box[z][y][x]+1;
                    q.add(newZ);
                    q.add(newY);
                    q.add(newX);
                }

            }
            
        }

    }

    public static boolean check(int z, int y, int x){
        // 범위 밖이면 false 반환
        if(z<0 || y<0 || x<0 || h<=z || n<=y || m<=x) return false;
        return true;
    }
}