import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;



public class boj4963{
    // 섬
    static int[][] land;
    static boolean[][] visited;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int count;
    static int w,h;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        // 테스트 케이스 0 0 을 만날때 까지 
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0)break;

            land = new int[h][w];
            visited = new boolean[h][w];
            count=0;

            // 섬만들기
            for(int i=0; i<h;i++){
                st= new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<h;i++){
                for(int j=0;j<w;j++){
                    if(land[i][j]==1 && visited[i][j]==false){ // 섬이고 방문한적없으면
                        BFS(i,j);
                        count++;
                    }
                }
            }
            
            bw.write(count+"\n");
        
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void BFS(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        
        int[] now = {y,x};
        q.add(now); // 넣을때 체크
        visited[now[0]][now[1]]=true;
        while(!q.isEmpty()){
            
            now = q.poll();
            //visited[now[0]][now[1]]=true; //방문체크

            //인접이면
            for(int i=0; i<8;i++){
                int sy= now[0]+dy[i];
                int sx= now[1]+dx[i];
                if(sy < 0 || sx < 0 || sy >= h || sx >= w) continue;
                
                // 방문한적없는 인접 땅 
                if(land[sy][sx]==1 && visited[sy][sx]==false){
                    int[] a = {sy, sx};
                    q.add(a);
                    visited[a[0]][a[1]]=true;
                }
            }
        }
        
    }
}