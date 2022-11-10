import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class boj2583{

    static boolean[][] map;  // 맵
    static List<Integer> list=new ArrayList<>();  //정렬을위한
    static int[] dy = {1,-1,0,0};   // 상하좌우
    static int[] dx = {0,0,-1,1};
    static int m;
    static int n;
    static int width;
   
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 층
        n = Integer.parseInt(st.nextToken()); // 넓이
        int k = Integer.parseInt(st.nextToken());

        map = new boolean[m][n];

        for(int t=0;t<k;t++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int i=y1;i<y2;i++){
                for(int j=x1;j<x2;j++){
                    map[i][j]=true;
                }
            }
        }

        int count=0;//bfs 횟수
        for(int i=0;i<m;i++){  //층
            for(int j=0;j<n;j++){
                //방문하지않았으면 bfs
                if(map[i][j]==false){
                    BFS(i, j);
                    count++;
                }
            }      
        }

        bw.write(count+"\n");
        Collections.sort(list);// 정렬
        for(int a : list){
            bw.write(a+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void BFS(int y, int x){
        width=1; // 방문칸수 자기자신+1
        Queue<int[]> q = new LinkedList<>();
        int[] now= {y,x};
        q.add(now);
        map[now[0]][now[1]]=true; // 방문
        while(!q.isEmpty()){
            int[] poll=q.poll();
            for(int i=0;i<4;i++){
                int newY = poll[0]+dy[i];
                int newX = poll[1]+dx[i];
                if(newY<0 || newX<0 || newY>=m || newX>=n) continue;
                // 방문하지않았으면
                if(map[newY][newX]==false){
                    int[] check={newY,newX};
                    q.add(check);
                    width++; // 넣으면서 값 증가
                    map[newY][newX]=true; //큐에 넣으면서 방문체크
                }
            }
        }
        list.add(width);
        // list 초기화 안하면 문제 발생!!!
    }
}