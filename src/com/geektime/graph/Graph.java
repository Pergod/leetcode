package com.geektime.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 * @author 数据结构与算法课程代码
 *
 */
public class Graph {

	// 顶点的个数
	private int v;

	// 邻接表
	private LinkedList<Integer> adj[];

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			// 每个节点链接其它的节点
			adj[i] = new LinkedList<Integer>();
		}

	}

	public void addEdge(int s, int t) {
		// 无向图一条边存两次
		adj[s].add(t);
		adj[t].add(s);
	}

	/**
	 * 广度优先搜索
	 * 参考图例https://www.jianshu.com/p/70952b51f0c8
	 * @param start	起始顶点
	 * @param end	终止顶点
	 */
	public void bfs(int start, int end) {
		if (start == end){
			return;
		}
		// 用来记录已经被访问的顶点
		boolean[] visited = new boolean[v];
		visited[start] = true;
		// 是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点
		Queue<Integer> queue = new LinkedList<>();
		// 入队
		queue.add(start);
		// 用来记录搜索路径
		int[] prev = new int[v];
		// 初始化 -1
		for (int i = 0; i < v; ++i) {
			prev[i] = -1;
		}
		while (queue.size() != 0) {
			// 出队
			int w = queue.poll();
			for (int i = 0; i < adj[w].size(); ++i) {
				// w连接的
				int q = adj[w].get(i);
				if (!visited[q]) {
					// 记录搜索路径 w - q
					prev[q] = w;
					// 找到了终点
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

	// 全局变量或者类成员变量
	private boolean found = false;

	/**
	 * 深度优先搜索（递归实现）
	 * 参考图例https://www.jianshu.com/p/70952b51f0c8
	 * @param start		起始顶点
	 * @param end		终止顶点
	 */
	public void dfs(int start, int end) {
		// 判断是否访问到终点
		found = false;
		// 用来记录已经被访问的顶点
		boolean[] visited = new boolean[v];
		// 用来记录搜索路径
		int[] prev = new int[v];
		for (int i = 0; i < v; ++i) {
			prev[i] = -1;
		}
		recurDfs(start, end, visited, prev);
		print(prev, start, end);
	}

	/**
	 * 递归
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
				// 递归调用
				recurDfs(q, t, visited, prev);
			}
		}
	}

	 // 递归打印s->t的路径
	private void print(int[] prev, int s, int t) {
		if (prev[t] != -1 && t != s) {
			print(prev, s, prev[t]);
		}
		System.out.print(t + " ");
	}
}
