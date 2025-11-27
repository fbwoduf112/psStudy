import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int dist[];
    // visited 배열은 굳이 없어도 dist 값 비교로 충분하지만,
    // 혹시 모를 중복 방지를 위해 두셔도 됩니다. (여기선 제거하고 dist로만 제어)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 도착지점 (변수명 M -> K가 일반적이라 변경)

        // 1. 거리 배열 초기화
        dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 2. 다익스트라 실행
        dijkstra(N);
        
        // 3. 결과 출력
        System.out.println(dist[K]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        
        // 시작점 세팅: 시간 0, 큐에 삽입
        dist[start] = 0;
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node current = q.poll();
            int now = current.x;
            int time = current.time;

            // [최적화] 이미 구한 최단 시간보다 지금 꺼낸 시간이 더 크다면 스킵
            // (방문 체크와 비슷한 역할)
            if (dist[now] < time) continue;

            // 1. 순간이동 (*2) : 0초 소요
            int next = now * 2;
            if (next <= 100000 && dist[next] > time) {
                dist[next] = time; // 가중치 0 더함
                q.offer(new Node(next, dist[next]));
            }

            // 2. 걷기 (+1) : 1초 소요
            next = now + 1;
            if (next <= 100000 && dist[next] > time + 1) {
                dist[next] = time + 1; // 가중치 1 더함
                q.offer(new Node(next, dist[next]));
            }

            // 3. 걷기 (-1) : 1초 소요
            next = now - 1;
            if (next >= 0 && dist[next] > time + 1) {
                dist[next] = time + 1; // 가중치 1 더함
                q.offer(new Node(next, dist[next]));
            }
        }
    }
}

// Comparable을 구현하여 시간이 짧은 순으로 자동 정렬
class Node implements Comparable<Node> {
    int x;
    int time;

    public Node(int x, int time) {
        this.x = x;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time; // 시간 오름차순 정렬
    }
}