import java.util.*;
import java.io.*;

class Solution {
    
    static boolean[][] visited;
    static int answer = 1;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        
        visited = new boolean[maps.length][maps[0].length];
        
        BFS(maps);
        
        answer = maps[maps.length-1][maps[0].length-1];
        if(visited[maps.length-1][maps[0].length-1] == false) answer=-1;
        return answer;
    }
    
    public static void BFS(int[][] maps){
        if(visited[0][0]==true || maps[0][0]==0) return;
        maps[0][0]=1; // 처음시작은 1
        visited[0][0]=true;
        int[] start ={0,0};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
 
            int[] now = q.poll();
            for(int i=0; i<4;i++){
                int nextY = now[0]+dy[i];
                int nextX = now[1]+dx[i];
                         
                if(nextY<0 || nextX<0 || nextY >= maps.length || nextX>= maps[0].length) continue;
                if(visited[nextY][nextX]==false && maps[nextY][nextX]>=1){ // 방문한적없으면
                    visited[nextY][nextX]=true;
                    maps[nextY][nextX]=maps[now[0]][now[1]]+1; // 이전값 +1
                    int[] newNow = {nextY,nextX};
                    q.add(newNow);
                }
            }
        }
    }
    
}