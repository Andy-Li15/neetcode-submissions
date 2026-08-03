/*
trie for checking word startsWith
backtracking for checking all possibilities

for each letter in board, check if in trie, then recurse to 4 adjacent squares
*/

class Solution {
    private Set<String> result;
    private StringBuilder sb;
    private Trie trie;

    public List<String> findWords(char[][] board, String[] words) {
        result = new HashSet<>();
        sb = new StringBuilder();

        // make trie
        trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                getWords(board, i, j);
            }
        }
        return new ArrayList<>(result);
    }

    // check letter at board[i][j]
    private void getWords(char[][] board, int i, int j) {
        // check if indexes within bounds
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return;
        }

        // get current char, replace current char to prevent reuse
        char c = board[i][j];

        sb.append(c);
        String s = sb.toString();


        // check if adding current char could create new word
        if (trie.isPrefix(s)) {
            // check if adding current char creates new word
            if (trie.search(s)) {
                result.add(s);
            }
            board[i][j] = '#';
            getWords(board, i + 1, j);
            getWords(board, i - 1, j);
            getWords(board, i, j + 1);
            getWords(board, i, j - 1);
            board[i][j] = c;
        }

        // backtrack
        sb.deleteCharAt(sb.length() - 1);

    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class Trie {
    private TrieNode root = new TrieNode();

    void insert(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }

    boolean search(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (c < 'a' || c > 'z') return false;
            cur = cur.children[c - 'a'];
            if (cur == null) return false;
        }
        return cur.isEnd;
    }

    boolean isPrefix(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (c < 'a' || c > 'z') return false;
            cur = cur.children[c - 'a'];
            if (cur == null) return false;
        }
        return true;
    }

}