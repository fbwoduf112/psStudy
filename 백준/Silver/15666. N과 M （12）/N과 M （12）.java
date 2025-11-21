import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static int arr[];
	static int ans[];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visit = new boolean[N];
		ans = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		backTracking(0,0);
	}
	
	static void backTracking(int at, int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			return;
		}
		
		int before = -1;
		for(int i=at; i<N; i++) {
				if(before != arr[i]) {
					before = arr[i];
					ans[depth] = arr[i];
					backTracking(i, depth+1);
				}
			}
		}
	}