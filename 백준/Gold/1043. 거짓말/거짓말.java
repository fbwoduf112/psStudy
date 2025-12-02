import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static boolean [] check;
	static ArrayList<Integer> [] party;
	static ArrayList<Integer> person;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		party = new ArrayList[M];
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<>();
		}
		//진실 아는 사람 입력
		st = new StringTokenizer(br.readLine(), " ");
		person = new ArrayList<>();
		
		//진실을 알고 있는 사람과 같이 있으면 모르는 사람도 아는 사람.
		int repeat;
		repeat = Integer.parseInt(st.nextToken());
		check = new boolean[N+1];
		for(int i=0; i<repeat; i++) {
			person.add(Integer.parseInt(st.nextToken()));
		}
		//같은 얘기 또 해도 됨.
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			repeat = Integer.parseInt(st.nextToken());
			for(int j=0; j<repeat; j++) {
				//배열에 추가
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		//진실을 아는 사람을 순서대로 q에 넣음.
		/**
		 * 예제 5기준
		 * ex)	큐에 1들어감
		 * 		첫번째 파티에서 5들어감.
		 * 		1탐색 끝나면, 5탐색
		 * 		5탐색 끝나면, 5를 진실을 아는 사람에 추가
		 *		큐에 2들어감
		 *		2번째 파티에서 6들어감.
		 *		2끝나면, 6탐색
		 *		6탐색 끝나면, 6을 진실을 아는 사람에 추가
		 *		... 
		 * 
		 * **/
		for(int i=0; i<person.size(); i++) {
			bfs(person.get(i));
		}
		answer();
	}
	
	public static void answer() {
		//파티 순회 => 사람 순회
		for(int i=0; i<M; i++) {
			//파티 내부 사람이 진실을 앎?
			for(int k=0; k<party[i].size(); k++) {
				int temp = party[i].get(k);
				int tempCnt = 0;
				for(int j=0; j<person.size(); j++) {
					if(temp == person.get(j)) {
						tempCnt++;
						break;
					}
				}
				if(tempCnt == 0) {
					ans++;
					break;
				}
				else break;
			}
		}
		System.out.print(ans);
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		//들리지 않았으면 시작
		//start 들리면 출발
		if(!check[start]) {
			//방문 처리
			check[start] = true;
			//큐가 빌때까지
			while(!q.isEmpty()) {
				//사람 뺌
				int num = q.poll();
				//파티 순회
				for(int i=0; i<M; i++) {
					//파티 내 사람 순회
					int numCheck = 0; //진실을 아는 사람 있는지 체크
					//해당 파티에서 진실을 아는 사람 있는지 체크
					for(int j=0; j<party[i].size(); j++) {
						int temp = party[i].get(j);
						if(temp == num) numCheck++;
					}
					if(numCheck != 0) {
						for(int j=0; j<party[i].size(); j++) {
							//만약 해당 파티에 있는 사람중 검사하지 않았다?
							if(!check[party[i].get(j)]) {
								q.add(party[i].get(j));
								check[party[i].get(j)] = true;
								person.add(party[i].get(j));
							}
						}
					}
				}
			}
		}
	}
}
