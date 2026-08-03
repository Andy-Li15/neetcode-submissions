/*
TrieNode store TrieNodes of up to 26 following letters (a-z)
*/
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur = cur.children[c - 'a'];
            if (cur == null) return false;
        }
        if (cur.endOfWord) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            cur = cur.children[c - 'a'];
            if (cur == null) return false;
        }
        return true;
    }
}
