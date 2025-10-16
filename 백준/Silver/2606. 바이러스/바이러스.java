import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr [][];
	static boolean visit []; 
	static int count, node;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		node = Integer.parseInt(br.readLine())+1;
		int line = Integer.parseInt(br.readLine());
		
		arr = new int[node][node];
		visit = new boolean[node];
		count = 0;
		for(int i=0; i<line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr [a][b] = arr[b][a] = 1;
		}
		
			dfs(1);
			System.out.println(count-1);
	}
	static void dfs(int num) {
		visit[num] = true;
		count++;
		
		for(int i=0; i<node; i++) {
			if(arr[num][i] == 1 && !visit[i]) dfs(i);
		}
	}
}