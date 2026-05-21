/*
Ideas
Use hashmap
    input: letter counts
    output: list

sort strings
    char[] temp = strs[i].toCharArray();
    Arrays.sort(temp);
    String str = String(temp);

New hashmap with sorted strings
    input: sorted array (string)
    output: list
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // get key
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);

            // add str to List
            if (!map.containsKey(sorted)) map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
