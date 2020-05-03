package com.geektime.match;

/**
 * trie�����������
 * @author ���ݽṹ���㷨�γ�
 *
 */
public class Trie {
	// �洢�������ַ�
	private TrieNode root = new TrieNode('/'); 

	// ��Trie���в���һ���ַ���
	public void insert(char[] text) {
		TrieNode p = root;
		for (int i = 0; i < text.length; ++i) {
			// ��ȡ�ַ��±�
			int index = text[i] - 'a';
			if (p.children[index] == null) {
				TrieNode newNode = new TrieNode(text[i]);
				p.children[index] = newNode;
			}
			p = p.children[index];
		}
		p.isEndingChar = true;
	}

	// ��Trie���в���һ���ַ���
	public boolean find(char[] pattern) {
		TrieNode p = root;
		for (int i = 0; i < pattern.length; ++i) {
			int index = pattern[i] - 'a';
			if (p.children[index] == null) {
				return false; // ������pattern
			}
			p = p.children[index];
		}
		if (p.isEndingChar == false)
			return false; // ������ȫƥ�䣬ֻ��ǰ׺
		else
			return true; // �ҵ�pattern
	}

	// �ڵ�
	public class TrieNode {
		public char data;
		public TrieNode[] children = new TrieNode[26];
		public boolean isEndingChar = false;

		public TrieNode(char data) {
			this.data = data;
		}
	}
}