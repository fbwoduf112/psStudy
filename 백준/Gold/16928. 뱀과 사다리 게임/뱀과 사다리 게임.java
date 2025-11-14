import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int arr[] = new int[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<101; i++) arr[i] = i;
		
		for(int i=0; i<n+m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a] = b;
		}
		
		System.out.println(bfs(1));
		
	}
	static int bfs(int x) {
		//방문 및 숫자 체크 위한 101;
		int [] check = new int[101];
		Queue<Integer> q = new LinkedList<>();
		//첫 방문에 1 넣고
		q.add(x);
		//첫 칸에 0넣고
		check[x] = 0;
		
		while(true) {
			//빼고
			int visitNum = q.poll();
			//주사위 굴리고
			for(int i=1; i<7; i++) {
				//이동할 칸 정하고
				int moveNum = visitNum + i;
				if(moveNum > 100) {
					continue;
				}
				if(check[arr[moveNum]] == 0) {
					q.offer(arr[moveNum]);
					check[arr[moveNum]] = check[visitNum] + 1;
				}
				if(arr[moveNum] == 100) return check[100];
			}
		}
	}
}