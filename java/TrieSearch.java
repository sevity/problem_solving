package java;
public class TrieSearch {

    static class Trie {
        Node root = new Node();

        static class Node {
            Node[] children = new Node[26];
            boolean end = false;
        }

        void insert(String s) {
            Node node = root;
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Node();
                }
                node = node.children[index];
            }
            node.end = true;
        }

        boolean search(String s) {
            Node node = root;
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                node = node.children[index];
                if (node == null) return false;
            }
            return node.end;
        }

        boolean startsWith(String prefix) {
            Node node = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                node = node.children[index];
                if (node == null) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple")); // returns true
        System.out.println(trie.search("app")); // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app")); // returns true
    }
}
