import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static boolean visited[];
	static int dist[];
	static ArrayList<Bus> [] busMap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		dist = new int[N+1];
		busMap = new ArrayList[N+1];
		
		
		for(int i=1; i<N+1; i++) {
			busMap[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			busMap[start].add(new Bus(end, 1));
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		dajikstra(X);
		
		int cnt = 0;
		for(int i=1; i<dist.length; i++) {
			if(dist[i] == K) {
				System.out.println(i);
				cnt++;
			}
		}
		if(cnt == 0) System.out.println(-1);
	}
	
	public static void dajikstra(int start) {
		PriorityQueue <Bus> que = new PriorityQueue<>();
		dist[start] = 0;
		que.offer(new Bus(start, 0));
		
		while(!que.isEmpty()) {
			Bus b = que.poll();
			int currEnd = b.arrive;
			
			if(!visited[currEnd]) {
				visited[currEnd] = true;
				
				for(int i=0; i<busMap[currEnd].size(); i++) {
					Bus bus = busMap[currEnd].get(i);
					
					if(!visited[bus.arrive] && dist[bus.arrive] > dist[currEnd] + bus.weight) {
						//방문 안했고 도착지점의 값이 현재값보다 크다면 갱신
						dist[bus.arrive] = dist[currEnd] + bus.weight;
						//뭘 방문해야할까. 현재 방문이랑 그 가중치
						que.offer(new Bus(bus.arrive, dist[bus.arrive]));
					}
				}
			}
			
		}
	}
}

class Bus implements Comparable<Bus>{
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