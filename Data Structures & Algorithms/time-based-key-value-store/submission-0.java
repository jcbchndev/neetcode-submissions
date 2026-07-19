class TimeMap {

    private Map<String, List<List<String>>> time_map;

    public TimeMap() {
        time_map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        time_map.putIfAbsent(key, new ArrayList<>());
        List<String> pair = new ArrayList<>(
            List.of(value, Integer.toString(timestamp))
        );
        time_map.get(key).add(pair);
    }
    
    public String get(String key, int timestamp) {
        String output = "";

        if (!time_map.containsKey(key)){
            return output;
        }

        List<List<String>> vals = time_map.get(key);

        int l = 0;
        int r = vals.size() - 1;

        while (l <= r){
            int mid = (l + r) / 2;
            List<String> pair = vals.get(mid);
            if (Integer.parseInt(pair.get(1)) <= timestamp){
                output = pair.get(0);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return output;
    }
}
