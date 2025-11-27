import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static boolean visited[];
	static int dist[];
	static ArrayList<Bus> busMap[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		dist = new int[N+1];
		busMap = new ArrayList [N+1];
		
		for(int i=1; i<N+1; i++) {
			busMap[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			busMap[u].add(new Bus(v, w));
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dajikstra(K);
		
		for(int i=1; i<N+1; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
	public static void dajikstra(int start) {
		PriorityQueue<Bus> q = new PriorityQueue<>();
		dist[start] = 0;
		q.offer(new Bus(start, 0));
		
		while(!q.isEmpty()) {
			Bus b = q.poll();
			int currEnd = b.arrvie;
			
			if(visited[currEnd]) continue;
			visited[currEnd] = true;
			
			for(Bus next : busMap[currEnd]) {
				if(!visited[next.arrvie] && dist[next.arrvie] > dist[currEnd] + next.weight) {
					dist[next.arrvie] = dist[currEnd] + next.weight;
					q.offer(new Bus(next.arrvie, dist[next.arrvie]));
				}
			}
		}
	}
	
}


class Bus implements Comparable<Bus> {
	int arrvie;
	int weight;
	
	public Bus(int arrive, int weight) {
		this.arrvie = arrive;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Bus b) {
		return weight - b.weight;
	}
}