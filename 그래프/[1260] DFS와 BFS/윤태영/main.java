import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
public class Main{
	static int N;
	static int M;
	static int V;
	static ArrayList<Integer>adj[];
	static boolean invisited[];
	static StringBuilder sb=new StringBuilder();
	public static void main(String[]args)throws IOException{
		 
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		V=Integer.parseInt(st.nextToken());
		
		
		adj=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			
			adj[i]=new ArrayList<Integer>();
		}
	   
		invisited=new boolean [N+1];
		
		for(int i=0;i<M;i++) {	
		  st=new StringTokenizer(br.readLine());
		  int a=Integer.parseInt(st.nextToken());
		  int b=Integer.parseInt(st.nextToken());
			
		  adj[a].add(b);
		  adj[b].add(a);
			
		}
		 for (int i = 1; i <= N; i++) {
	            Collections.sort(adj[i]);
	        }
		
	DFS(V); 
	sb.append("\n");
	invisited=new boolean[N+1];   //초기화 
	BFS();
	System.out.println(sb);
		
	}
	
	static void DFS(int a) {
	    // 1.체크인 
		invisited[a]=true;
		sb.append(a).append(" ");
		for(int follow:adj[a]) {//2. a점 즉 시작점과 연결된 점들을 순회
			  //방문 할수 있는가? 조건이 무엇인가?
			if(invisited[follow]==false) {//방문 하지 않은 곳만 갈수 있다
				DFS(follow);// 조건이 충족하면 계속 내려가면 된다
			}
		}
		
		
			
	}	  		
		
	static void BFS() {
		Queue<Integer>q=new LinkedList<>();  //BFS는 QUEUE를 만들어 준다
		invisited[V]=true;// 시작점체크인 
		q.add(V); //Q에다 집어넣는다
		
		while(!q.isEmpty()) {
			int temp=q.poll();
			sb.append(temp).append(" ");
		    for(int i:adj[temp]) {//연결된 점 전체를 순회
		    	if(invisited[i]==false) {
		    		invisited[i]=true;  // 방문한곳은 방문확정   		
		    		q.add(i);
		    	}
		    }			
		}		
	}
}