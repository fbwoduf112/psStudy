import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static ArrayList<Bus> [] busMap; 
	static int [] dist;
	static boolean [] check;
	static final int INF = 200000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		check = new boolean[N+1];
		busMap = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			busMap[i] = new ArrayList<>();
		}
		
		int E = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end =  Integer.parseInt(st.nextToken());
			int weight =  Integer.parseInt(st.nextToken());
			busMap[start].add(new Bus(end, weight));
			busMap[end].add(new Bus(start, weight));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		//다익스트라 만약 두 정점이 이어져있지 않는다면 돌아가야함.
		int res1 = 0;
		int res2 = 0;
		
		res1 += dajkstra(1, v1);
		res1 += dajkstra(v1, v2);
		res1 += dajkstra(v2, N);
		
		res2 += dajkstra(1, v2);
		res2 += dajkstra(v2, v1);
		res2 += dajkstra(v1, N);
		int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
		System.out.println(ans);
	}
	
	public static int dajkstra(int start, int end) {
		PriorityQueue <Bus> q = new PriorityQueue<>();
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);
		
		q.add(new Bus(start, 0));
		dist[start] = 0;
		while(!q.isEmpty()) {
			Bus bus = q.poll();
			int cur = bus.arrive;
			
			
			
			if(!check[cur]) {
				check[cur] = true;
				for(Bus b : busMap[cur]) {
					if(!check[b.arrive] && dist[b.arrive] > dist[cur] + b.weight) {
						dist[b.arrive] = dist[cur] + b.weight;
						q.add(new Bus(b.arrive, dist[b.arrive]));
					}
				}
			}
		}
		return dist[end];
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