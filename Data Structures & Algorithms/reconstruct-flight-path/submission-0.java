class Solution {

    private HashMap<String, List<String>> paths = new HashMap<>();
    private HashMap<String, Integer> visited = new HashMap<>(); // 동일한 비행기 티켓
    private List<String> ans = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for(int i = 0; i < tickets.size(); i++) {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);

            if(!paths.containsKey(from)) {
                paths.put(from, new ArrayList<>());
            }

            paths.get(from).add(to);
            String key = from + "_" + to;
            visited.put(key, visited.getOrDefault(key, 0) + 1);
        }

        for(String key: paths.keySet()) {
            Collections.sort(paths.get(key));
        }

        List<String> start = new ArrayList<>();
        start.add("JFK");
        dfs("JFK", start, tickets.size());

        return ans;
    }

    private boolean dfs(String cur, List<String> answer, int totalTickets) { // 정답인 경로

        if(answer.size() == totalTickets + 1) {
            ans = answer;
            return true;
        }

        if(!paths.containsKey(cur)) return false;

        for(String next : paths.get(cur)) {
            String key = cur + "_" + next;
            if(visited.getOrDefault(key, 0) >= 1) {
                visited.put(key, visited.getOrDefault(key, 0) - 1);
                answer.add(next);
                if(dfs(next, answer, totalTickets)) return true; // 정답 찾으면 바로 반환
                answer.remove(answer.size() - 1);
                visited.put(key, visited.getOrDefault(key, 0) + 1);
            }
        }

        return false;
    }
}
