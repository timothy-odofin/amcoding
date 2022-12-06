package org.example.string;

import org.example.model.TrieNode;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to
 * * efficiently store and retrieve keys in a dataset of strings.
 * * There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 *     Trie() Initializes the trie object.
 *     void insert(String word) Inserts the string word into the trie.
 *     boolean search(String word) Returns true if the string word is in
 *     *     the trie (i.e., was inserted before), and false otherwise.
 *     boolean startsWith(String prefix) Returns true if there is a previously
 *          inserted string word that has the
 *         prefix prefix, and false otherwise.
 * * * */
public class ImplementTrie {
    private TrieNode root;



    public ImplementTrie() {

        root = new TrieNode();

    }



    // Inserts a word into the trie.

    public void insert(String word) {

        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {

            char currentChar = word.charAt(i);

            if (!node.containsKey(currentChar)) {

                node.put(currentChar, new TrieNode());

            }

            node = node.get(currentChar);

        }

        node.setEnd();

    }
    private TrieNode searchPrefix(String word) {

        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {

            char curLetter = word.charAt(i);

            if (node.containsKey(curLetter)) {

                node = node.get(curLetter);

            } else {

                return null;

            }

        }

        return node;

    }
    // Returns if there is any word in the trie

    // that starts with the given prefix.
/**
 * Complexity Analysis
 *
 *     Time complexity : O(m)
 *
 *     Space complexity : O(1)
 * * */
    public boolean startsWith(String prefix) {

        TrieNode node = searchPrefix(prefix);

        return node != null;

    }
}
