package com.geektime.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����ͼ
 * @author ���ݽṹ���㷨�γ̴���
 *
 */
public class Graph {

	// ����ĸ���
	private int v;

	// �ڽӱ�
	private LinkedList<Integer> adj[];

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			// ÿ���ڵ����������Ľڵ�
			adj[i] = new LinkedList<Integer>();
		}

	}

	public void addEdge(int s, int t) {
		// ����ͼһ���ߴ�����
		adj[s].add(t);
		adj[t].add(s);
	}

	/**
	 * �����������
	 * �ο�ͼ��https://www.jianshu.com/p/70952b51f0c8
	 * @param start	��ʼ����
	 * @param end	��ֹ����
	 */
	public void bfs(int start, int end) {
		if (start == end){
			return;
		}
		// ������¼�Ѿ������ʵĶ���
		boolean[] visited = new boolean[v];
		visited[start] = true;
		// ��һ�����У������洢�Ѿ������ʡ��������Ķ��㻹û�б����ʵĶ���
		Queue<Integer> queue = new LinkedList<>();
		// ���
		queue.add(start);
		// ������¼����·��
		int[] prev = new int[v];
		// ��ʼ�� -1
		for (int i = 0; i < v; ++i) {
			prev[i] = -1;
		}
		while (queue.size() != 0) {
			// ����
			int w = queue.poll();
			for (int i = 0; i < adj[w].size(); ++i) {
				// w���ӵ�
				int q = adj[w].get(i);
				if (!visited[q]) {
					// ��¼����·�� w - q
					prev[q] = w;
					// �ҵ����յ�
					if (q == end) {
						print(prev, start, end);
						return;
					}
					visited[q] = true;
					queue.add(q);
				}
			}
		}
	}

	// ȫ�ֱ����������Ա����
	private boolean found = false;

	/**
	 * ��������������ݹ�ʵ�֣�
	 * �ο�ͼ��https://www.jianshu.com/p/70952b51f0c8
	 * @param start		��ʼ����
	 * @param end		��ֹ����
	 */
	public void dfs(int start, int end) {
		// �ж��Ƿ���ʵ��յ�
		found = false;
		// ������¼�Ѿ������ʵĶ���
		boolean[] visited = new boolean[v];
		// ������¼����·��
		int[] prev = new int[v];
		for (int i = 0; i < v; ++i) {
			prev[i] = -1;
		}
		recurDfs(start, end, visited, prev);
		print(prev, start, end);
	}

	/**
	 * �ݹ�
	 * @param w
	 * @param t
	 * @param visited
	 * @param prev
	 */
	private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
		if (found == true){
			return;
		}
		visited[w] = true;
		if (w == t) {
			found = true;
			return;
		}
		for (int i = 0; i < adj[w].size(); ++i) {
			int q = adj[w].get(i);
			if (!visited[q]) {
				prev[q] = w;
				// �ݹ����
				recurDfs(q, t, visited, prev);
			}
		}
	}

	 // �ݹ��ӡs->t��·��
	private void print(int[] prev, int s, int t) {
		if (prev[t] != -1 && t != s) {
			print(prev, s, prev[t]);
		}
		System.out.print(t + " ");
	}
}
