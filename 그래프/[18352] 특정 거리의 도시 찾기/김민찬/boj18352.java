

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;

public class boj18352{

    static int target;
    static int start;
    static int node;
    static int edge;
    static List<Integer>[] list;
    static boolean[] visitied;
    static int[] distance; // 굳이 나눈이유는 코드 이해를 위해
    
    
    public static void main(String[] args)throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visitied = new boolean[node+1]; //  node +1 만큼한이유는 시작점이 1부터여서
        distance = new int[node+1]; // 초기화는 자동으로 되나...? ㅇㅇ 0으로 된다 
        
        // 인접리스트 초기화!
        list = new ArrayList[node+1]; // 왜 이걸 잊었나.......!!!! 
        for(int i=0;i<=node;i++){
            list[i] = new ArrayList<Integer>(); // 까먹지말자!!! arrayList<여기에값써주기!!!>
        }

        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        
        BFS(start);
        int cnt=0;
        for(int i=1;i<=node;i++){
            if(distance[i]==target){
                bw.write(i+"\n");
                cnt++;
            }
        }
        if(cnt==0) bw.write("-1");


        // for(int i=0;i<distance.length;i++){
        //     bw.write("이게 값입니다!"+distance[i] +"\n");
        // }


        bw.flush();
    }

    static void BFS(int idx){

        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visitied[idx]=true;
        distance[idx]=0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : list[now]){
                if(visitied[i]==false){
                    q.add(i);
                    distance[i]=distance[now]+1;
                    visitied[i]=true;
                }
            }
        }
        
    }

    
}
