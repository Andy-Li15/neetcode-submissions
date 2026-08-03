/*
use trie
for addWord, add like in a trie
for search, use queue to check multiple TrieNodes when '.' appears
*/

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        for (char c : word.toCharArray()) {
            int size = queue.size();
            if (size == 0) return false;

            for (int i = 0; i < size; i++) {
                TrieNode cur = queue.remove();
                if (c == '.') {
                    for (TrieNode child : cur.children) {
                        if (child != null) queue.add(child);
                    }
                } else {
                    cur = cur.children[c - 'a'];
                    if (cur != null) queue.add(cur);
                }
            }
        }
        for (TrieNode node : queue) {
            if (node.isEnd) return true;
        }
        return false;
    }
}
