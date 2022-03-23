package com.vaibhav.snippets.data_structures;

import java.util.Map;

public class TrieImplementation {
    class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean end;

        TrieNode() {
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(Map<Character, TrieNode> children) {
            this.children = children;
        }

        public boolean isEnd() {
            return end;
        }

        public void setEnd(boolean end) {
            this.end = end;
        }
    }

    class Trie {
        private TrieNode root;

        Trie() {
            root = new TrieNode();
            root.setEnd(false);
        }

        public void insert(String str) {
            TrieNode current = root;
            char[] characters = str.toCharArray();
            for (char character : characters) {
                TrieNode node = current.getChildren().get(character);
                if (node == null) {
                    node = new TrieNode();
                    current.setChildren(Map.of(character, node));
                }
                current = node;
            }
            current.setEnd(true);
        }

        public boolean searchString(String str) {

            TrieNode trev = root;
            char currentCharacter = str.charAt(0);
            int i = 1;
            while(trev.getChildren().containsKey(currentCharacter)) {
                if (trev.isEnd() && i == str.length()) {
                    return true;
                }
                trev = trev.getChildren().get(currentCharacter);
                i++;
                currentCharacter = str.charAt(i);
            }
            return false;
        }
    }
}
