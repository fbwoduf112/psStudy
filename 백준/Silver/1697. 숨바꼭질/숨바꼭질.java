import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int visited [];
	static int M;
	public static void main(String[] args) throws IOException {	 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new int [100001];
		int result = bfs(N);
		System.out.println(result);
	}
	 static int bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		int index = node;
		int n = 0;
		visited[index] = 1;
		while(queue.isEmpty() == false) {
			n = queue.poll();
			if(n==M) {
				return visited[n]-1;
			}
			if(n-1>=0 && visited[n-1] == 0) {
				visited[n-1] = visited[n]+1;
				queue.add(n-1);
			}
			if(n+1 <= 100000 && visited[n+1] == 0) {
				visited[n+1] = visited[n]+1;
				queue.add(n+1);
			}
			if(2*n <= 100000 && visited[2*n] == 0) {
				visited[2*n] = visited[n] + 1;
				queue.add(2*n);
			}
			
		}
		return -1;
	}
}