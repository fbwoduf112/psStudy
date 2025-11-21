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
	static Set<String> set;
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
		set = new LinkedHashSet<>();
		Arrays.sort(arr);
		backTracking(0);

		set.forEach(System.out::println);
	}
	
	static void backTracking(int depth) {
		if(depth == M) {
			String num = "";
			for(int i=0; i<M; i++) {
				num += ans[i] + " ";
			}
			set.add(num);
			return;
		}
	
			for(int i=0; i<N; i++) {
				if(!visit[i]) {
					visit[i] = true;
					ans[depth] = arr[i];
					backTracking(depth+1);
					visit[i] = false;
				}
			}
	}
}