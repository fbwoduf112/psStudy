import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean check[];
	static int N, M;
	public static void main(String[] args) throws IOException {	 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int [N+1][N+1];
		check = new boolean [N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
		int cnt = 0;
		for(int i=1; i<N+1; i++) {
			if(!check[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	
	static void dfs(int start) {
		check[start] = true;
		
		for(int i=1; i<N+1; i++) {
			if(arr[start][i] == 1 && !check[i]) {
				dfs(i);
			}
		}
	}
}