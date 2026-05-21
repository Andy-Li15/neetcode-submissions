class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        int n = str.length();
        while (i < n) {
            // get length
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            // get string and add to strs
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            strs.add(str.substring(i, j));
            i = j;
        }
        return strs;
    }
}
