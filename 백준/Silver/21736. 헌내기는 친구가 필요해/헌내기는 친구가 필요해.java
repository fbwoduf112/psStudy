import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char arr[][];
	static boolean check[][];
	static int cnt;
	static int N, M;
	public static void main(String[] args) throws IOException {	 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		check = new boolean[N][M];
		int x = 0;
		int y = 0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == 'I') {
					x=j;
					y=i;
				}
			}
		}
		//System.out.println(x + " " + y);
		//x는 가로
		//y는 세로
		backTracking(x, y);
		if(cnt == 0) System.out.println("TT");
		else System.out.println(cnt);
	}
	static void backTracking(int x, int y) {
		if(check[y][x]) return;
		if(arr[y][x] == 'X') return;
		else if(arr[y][x] == 'P') cnt++;
		//왼쪽으로
		if(x-1 >= 0) {
			check[y][x] = true;
			backTracking(x-1, y);
		}
		//오른쪽으로
		if(x+1 < M) {
			check[y][x] = true;
			backTracking(x+1, y);
		}
		//아래로
		if(y+1 < N) {
			check[y][x] = true;
			backTracking(x, y+1);
		}
		//위로
		if(y-1 >= 0) {
			check[y][x] = true;
			backTracking(x, y-1);
		}
		
		
	}
}