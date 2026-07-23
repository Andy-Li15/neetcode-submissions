/*
class TimeMap
    use a HashMap to link keys to a list of value-timestamp pairs
    set adds a value-timestamp pair to a key's list
    get performs binary search on a key's list to find the correct value
*/
class TimeMap {

    // TimeStamp links value and timestamp
    // map links key and TimeStamps
    private record TimeStamp(String value, Integer timestamp) {}
    private HashMap<String, ArrayList<TimeStamp>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    // set adds a value-timestamp pair to a key's list
    public void set(String key, String value, int timestamp) {
        // get ArrayList of TimeStamps
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        ArrayList<TimeStamp> keyList = map.get(key);
        
        // since timestamps strictly increasing, appending keeps list in order
        keyList.add(new TimeStamp(value, timestamp));
    }
    
    // get performs binary search on a key's list to find the correct value
    public String get(String key, int timestamp) {
        // if key does not exist, return ""
        if (!map.containsKey(key)) {
            return "";
        }
        ArrayList<TimeStamp> keyList = map.get(key);
        return binarySearch(keyList, timestamp);
    }

    private String binarySearch(ArrayList<TimeStamp> keyList, int timestamp) {
        int left = 0;
        int right = keyList.size() - 1;
        String value = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            TimeStamp midStamp = keyList.get(mid);
            int midTimestamp = midStamp.timestamp();

            if (midTimestamp == timestamp) { // found value
                return midStamp.value();
            } else if (midTimestamp < timestamp) { // potential value 
                value = midStamp.value();
                left = mid + 1; // check following timestamps
            } else { // after timestamp, not valid
                right = mid - 1; // checks previous timestamps
            }
        }
        return value;
    }
}
