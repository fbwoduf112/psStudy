import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int [][] graph = new int[N][N];
		int [][] ans = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) { //중간
			for(int j=0; j<N; j++) { //시작
				
				if(graph[j][i] == 0) continue;
				ans[j][i] = 1;
				for(int s=0; s<N; s++) { //끝
					if(graph[i][s] == 0) continue;
					graph[j][s] = 1;
					ans[j][s] = 1;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}
}