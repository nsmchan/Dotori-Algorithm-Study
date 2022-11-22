import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;

public class boj2667{

    static int cnt=0;
    static int size;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<Integer>(); // 개수출력, 초기화
    //상하좌우 
    static int[] dx ={0,0,1,-1};
    static int[] dy ={-1,1,0,0};

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        size = Integer.parseInt(br.readLine());

        // 초기화
        visited = new boolean[size][size];
        map = new int[size][size];

        // 맵 만들기
        for(int i=0;i<size;i++){
            String[] str = br.readLine().split("");
            for(int j=0;j<size;j++){
                
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        // BFS
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(visited[i][j]==false && map[i][j]!=0){
                    BFS(i,j);
                    cnt++;  // bfs 반복횟수 = 총단지수
                }
            }
        }

        bw.write(cnt+"\n");
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            bw.write(list.get(i)+"\n");
        }
        bw.flush();
        
    }
    
    static void BFS(int a, int  b){
        Queue<int[]> q = new LinkedList<>();
        int[] start = {a,b};
        int count=1;  // 시작집을 체크했으니 1부터시작
        q.add(start);
        visited[a][b]=true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0;i<4;i++){
                int y =  now[0]+dy[i];
                int x =  now[1]+dx[i];
                if(x<0 || y<0 || x>=size || y>=size) continue;
                if(visited[y][x]==false && map[y][x]!=0){
                    visited[y][x]=true;
                    int[] idx = {y,x};
                    q.add(idx);
                    count++;    // 단지내 집의 수
                }
                
            }
            
        }
        list.add(count);

    }
}