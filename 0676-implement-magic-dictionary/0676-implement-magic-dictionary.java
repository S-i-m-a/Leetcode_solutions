class MagicDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    private TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
    }

    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root, false);
    }

    private boolean dfs(char[] word, int index, TrieNode node, boolean modified) {
        if (index == word.length) {
            return modified && node.isWord;
        }

        int c = word[index] - 'a';
        for (int i = 0; i < 26; i++) {
            if (node.children[i] == null) continue;
            if (i == c) {
                if (dfs(word, index + 1, node.children[i], modified)) return true;
            } else {
                if (!modified && dfs(word, index + 1, node.children[i], true)) return true;
            }
        }

        return false;
    }
}
