import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Bus> busMap[];
	static int dist[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
	
		busMap = new ArrayList[N+1];
		visited = new boolean[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=1; i<=N; i++) {
			busMap[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			busMap[u].add(new Bus(v, w));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dajikstra(start);
		System.out.println(dist[end]);
	}
	
	public static void dajikstra(int start) {
		PriorityQueue<Bus> q = new PriorityQueue<>();
		dist[start] = 0;
		q.offer(new Bus(start, 0));
		
		while(!q.isEmpty()) {
			Bus b = q.poll();
			int currEnd = b.arrive;
			
			if(visited[currEnd]) continue;
			
			visited[currEnd] = true;
			
			for(Bus next : busMap[currEnd]) {
				if(!visited[next.arrive] && dist[next.arrive] > dist[currEnd] + next.weight) {
					dist[next.arrive] = dist[currEnd] + next.weight;
					q.offer(new Bus(next.arrive, dist[next.arrive]));
				}
			}
		}
	}
}

class Bus implements Comparable<Bus> {
	int arrive;
	int weight;
	
	public Bus(int arrive, int weight) {
		this.arrive = arrive;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Bus b) {
		return weight - b.weight;
	}
}