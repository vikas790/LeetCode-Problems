class Trie {
    Trie[] children = new Trie[26]; // Array for storing children nodes
    int visited = 0; // To count how many times the prefix is visited
}

public class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie root = new Trie();
        
        // First, build the Trie and count visits for each prefix
        for (String word : words) {
            Trie node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
                node.visited++; // Increase visit count for the prefix
            }
        }
        
        // Now calculate the prefix score for each word
        int[] result = new int[words.length];
        int k = 0;
        for (String word : words) {
            Trie node = root;
            int score = 0;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                node = node.children[idx];
                score += node.visited;
            }
            result[k++] = score;
        }
        
        return result;
    }
}
