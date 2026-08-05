/*
get all letters in the alien dict

find first different letter between words
    if an invalid lexicographic ordering is found, return ""

perform dfs on each letter, add letter to a stack/list after processing
    if the letter is being processed, return false
    if a letter is done being processed, return true
    can use 2 hashsets or a hashmap to track this
if dfs is false, return ""

pop stack / reverse list and return

*/
class Solution {
    List<HashSet<Character>> adjList;
    Stack<Character> stack;
    HashSet<Character> seen;
    HashSet<Character> path;


    public String foreignDictionary(String[] words) {
        if (words.length == 0) return "";

        // get all letters in words
        boolean[] alphabet = new boolean[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                alphabet[c - 'a'] = true;
            }
        }

        // adjList[letter - 'a'] = list of letters know to be lexicographically after letter
        adjList = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            adjList.add(new HashSet<>());
        }
        
        // find diffs between adjacent words, add to adjList
        for (int i = 0; i < words.length - 1; i++) {
            char[] diff = firstDiff(words[i], words[i + 1]);
            if (diff[0] == '#') return ""; // invalid lexicographically
            if (diff[0] == '_') continue; // same word
            adjList.get(diff[0] - 'a').add(diff[1]);
        }

        // find lexicographical order of letters through dfs (topological sort)
        stack = new Stack<>(); 
        seen = new HashSet<>();
        path = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (!alphabet[i]) {
                continue;
            }
            if (!dfs((char)(i + 'a'))) {
                return "";
            }
        }
        
        // get lexicographical string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private boolean dfs(char current) {
        if (path.contains(current)) {
            return false;
        } else if (seen.contains(current)) {
            return true;
        }
        path.add(current);
        seen.add(current);

        for (char c : adjList.get(current - 'a')) {
            if (!dfs(c)) {
                return false;
            }
        }
        path.remove(current);
        stack.push(current);
        return true;
    }

    private char[] firstDiff(String first, String second) {
        for (int i = 0; i < first.length(); i++) {
            if (i >= second.length()) return new char[]{'#', '#'}; // invalid lexicographically
            if (first.charAt(i) != second.charAt(i)) {
                return new char[]{first.charAt(i), second.charAt(i)};
            }
        }
        return new char[]{'_', '_'};
    }
}
