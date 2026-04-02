class TimeMap {

    class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    HashMap<String, List<Pair>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key,new ArrayList<>());   
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {

        if(!map.containsKey(key)) {
            return "";
        }

        List<Pair> times = map.get(key);

        int start = 0;
        int end = times.size() - 1;
        int find = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(times.get(mid).timestamp <= timestamp) {
                find = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

       return find != -1 ? times.get(find).value : "";
    }
}
