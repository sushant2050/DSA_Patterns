package com.dsa.pattern;

import java.util.*;

/**
 * Demonstrates the <b>Prefix Trie (or Trie) Pattern</b>.
 *
 * <p>
 * A Trie (Prefix Tree) is a tree-like data structure used to efficiently store
 * and retrieve strings, especially for prefix-based queries like autocomplete
 * and word search.
 * </p>
 *
 * <h2>Key Idea</h2>
 * <ul>
 * <li>Each node represents a character of a string</li>
 * <li>Paths from root to a node represent prefixes of strings</li>
 * <li>Leaves or nodes with `isEndOfWord = true` represent complete words</li>
 * <li>Supports efficient insertion, search, and prefix queries</li>
 * </ul>
 *
 * <h2>When to Use</h2>
 * <ul>
 * <li>Autocomplete / predictive text</li>
 * <li>Spell checkers</li>
 * <li>Word search in dictionaries</li>
 * <li>Prefix counting and retrieval</li>
 * </ul>
 *
 * <h2>Example Implementation</h2>
 *
 * <pre>{@code
 * package com.dsa.pattern;
 *
 * public class PrefixTrieExample {
 *
 * 	static class TrieNode {
 * 		TrieNode[] children = new TrieNode[26];
 * 		boolean isEndOfWord;
 * 	}
 *
 * 	static class Trie {
 * 		TrieNode root;
 *
 * 		Trie() {
 * 			root = new TrieNode();
 * 		}
 *
 * 		// Insert word into trie
 * 		void insert(String word) {
 * 			TrieNode node = root;
 * 			for (char c : word.toCharArray()) {
 * 				int index = c - 'a';
 * 				if (node.children[index] == null)
 * 					node.children[index] = new TrieNode();
 * 				node = node.children[index];
 * 			}
 * 			node.isEndOfWord = true;
 * 		}
 *
 * 		// Search exact word
 * 		boolean search(String word) {
 * 			TrieNode node = root;
 * 			for (char c : word.toCharArray()) {
 * 				int index = c - 'a';
 * 				if (node.children[index] == null)
 * 					return false;
 * 				node = node.children[index];
 * 			}
 * 			return node.isEndOfWord;
 * 		}
 *
 * 		// Check if prefix exists
 * 		boolean startsWith(String prefix) {
 * 			TrieNode node = root;
 * 			for (char c : prefix.toCharArray()) {
 * 				int index = c - 'a';
 * 				if (node.children[index] == null)
 * 					return false;
 * 				node = node.children[index];
 * 			}
 * 			return true;
 * 		}
 * 	}
 *
 * 	public static void main(String[] args) {
 * 		Trie trie = new Trie();
 * 		trie.insert("apple");
 * 		trie.insert("app");
 * 		trie.insert("bat");
 *
 * 		System.out.println("Search 'app': " + trie.search("app"));
 * 		System.out.println("Search 'apple': " + trie.search("apple"));
 * 		System.out.println("Search 'bat': " + trie.search("bat"));
 * 		System.out.println("Starts with 'ap': " + trie.startsWith("ap"));
 * 		System.out.println("Starts with 'ba': " + trie.startsWith("ba"));
 * 		System.out.println("Search 'batman': " + trie.search("batman"));
 * 	}
 * }
 * }</pre>
 *
 * <h2>Complexity</h2>
 * <ul>
 * <li>Insertion / Search / Prefix query: O(L), where L is length of word or
 * prefix</li>
 * <li>Space Complexity: O(ALPHABET_SIZE * N * L) in worst case, often less in
 * practice</li>
 * </ul>
 *
 * <h2>Applications</h2>
 * <ul>
 * <li>Autocomplete / predictive text systems</li>
 * <li>Spell checking</li>
 * <li>Prefix search in dictionaries</li>
 * <li>Counting words with common prefixes</li>
 * </ul>
 */
public class PrefixTrie {

	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isEndOfWord;
	}

	static class Trie {
		TrieNode root;

		Trie() {
			root = new TrieNode();
		}

		// Insert word into trie
		void insert(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				int index = c - 'a';
				if (node.children[index] == null)
					node.children[index] = new TrieNode();
				node = node.children[index];
			}
			node.isEndOfWord = true;
		}

		// Search exact word
		boolean search(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				int index = c - 'a';
				if (node.children[index] == null)
					return false;
				node = node.children[index];
			}
			return node.isEndOfWord;
		}

		// Check if prefix exists
		boolean startsWith(String prefix) {
			TrieNode node = root;
			for (char c : prefix.toCharArray()) {
				int index = c - 'a';
				if (node.children[index] == null)
					return false;
				node = node.children[index];
			}
			return true;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.insert("app");
		trie.insert("bat");

		System.out.println("Search 'app': " + trie.search("app"));
		System.out.println("Search 'apple': " + trie.search("apple"));
		System.out.println("Search 'bat': " + trie.search("bat"));
		System.out.println("Starts with 'ap': " + trie.startsWith("ap"));
		System.out.println("Starts with 'ba': " + trie.startsWith("ba"));
		System.out.println("Search 'batman': " + trie.search("batman"));
	}
}