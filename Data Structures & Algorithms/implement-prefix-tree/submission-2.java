/*
First trie implementation attempt
Used hashmap to allow for strings with any character
*/
class PrefixTree {

    HashMap<Character, PrefixTree> map;
    boolean isEnd;

    public PrefixTree() {
        map = new HashMap<>();
        isEnd = false;
    }

    public void insert(String word) {
        PrefixTree tree = this;
        for (char c : word.toCharArray()) {
            tree = tree.map.computeIfAbsent(c, ignored -> new PrefixTree());
        }
        tree.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree tree = this;
        for (char c : word.toCharArray()) {
            if (!tree.map.containsKey(c)) {
                return false;
            }
            tree = tree.map.get(c);
        }
        if (tree.isEnd) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        PrefixTree tree = this;
        for (char c : prefix.toCharArray()) {
            if (!tree.map.containsKey(c)) {
                return false;
            }
            tree = tree.map.get(c);
        }
        return true;
    }
}
