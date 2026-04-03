class Solution {

    private int[] dist;
    private List<List<int[]>> graph = new ArrayList<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        dist = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        for(int i = 0; i < times.length; i++) {
            int[] time = times[i];
            int a = time[0];
            int b = time[1];
            int c = time[2];

            graph.get(a).add(new int[]{b,c}); // 단 방향
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()) {
           int[] cur = pq.poll();
           int v = cur[0];
           int d = cur[1];

           if(d > dist[v]) continue;

           for(int[] next: graph.get(v)) {
              int t = next[0];
              int c = next[1];
              
              if(dist[t] > dist[v] + c) {
                dist[t] = dist[v] + c;
                pq.offer(new int[]{t,dist[t]});
              }
           } 
        }

        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            answer = Math.max(answer, dist[i]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
