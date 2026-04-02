class TimeMap {

    HashMap<String, HashMap<Integer,String>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) { // 정렬
        if(!map.containsKey(key)) {
            map.put(key,new HashMap<>());   
        }
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {

        if(!map.containsKey(key)) {
            return "";
        }

        List<Integer> times = new ArrayList<>(map.get(key).keySet());
        Collections.sort(times);

        int start = 0;
        int end = times.size() - 1;
        int find = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(times.get(mid) <= timestamp) {
                find = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

       return find != -1 ? map.get(key).get(times.get(find)) : "";
    }
}
