import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj1260{

	static List<Integer>[] list;
	static boolean[] visited;
	static BufferedReader br;
	static BufferedWriter bw;
	static int node;
	static int edge;
	static int start;
	public static void main(String[] args)throws IOException{
		
		br = new BufferedReader(new InputStreamReader(System.in)) ;
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		list = new ArrayList[node+1];
		visited = new boolean[node+1];

		// 인접리스트 초기화 visited 자동 false 초기화니까~
		for(int i=1;i<node+1;i++){
			list[i] = new ArrayList<Integer>();
		}

		// 인접리스트 만들기
		for(int i=0;i<edge;i++){
			st=new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}

		// 방문가능한 노드가 여러개일 경우 작은거부터
		for(int i=1;i<node+1;i++){
			Collections.sort(list[i]);
		}

		DFS(start);
		bw.write("\n");
		visited = new boolean[node+1];
		BFS(start);
		bw.flush();
		bw.close();
		br.close();
	}

	static void DFS(int index)throws IOException{
		if(visited[index]==true) return;
		bw.write(index+" ");
		visited[index]=true;
		for(int i : list[index]){
			if(visited[i]==false) DFS(i);
		}
	}

	static void BFS(int index)throws IOException{
		
		Queue<Integer> q = new LinkedList<>();
		q.add(index);
		visited[index]=true;
		while(!q.isEmpty()){
			int poll = q.poll();
			bw.write(poll+" ");
			for(int j : list[poll]){
				if(visited[j]==false){
					q.add(j);
					visited[j]=true;
				}
			}
			
		}
	}
}