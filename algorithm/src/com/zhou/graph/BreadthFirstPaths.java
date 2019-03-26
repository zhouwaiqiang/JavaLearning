package com.zhou.graph;

import com.zhou.datastructure.Queue;
import com.zhou.datastructure.Stack;

/**
 * Created by 强 on 2018/6/4.
 */
public class BreadthFirstPaths {
    private boolean[] marked; //到达该顶点的最短路径已知吗
    private int[] edgeTo; //到达该顶点已知路径上的最后一个顶点
    private final int s; //起点

    public BreadthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true; //标记起点
        queue.enqueue(s); //入队
        while (!queue.isEmpty()) {
            int v = queue.dequeue();// 从队列中删去下一个顶点
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;//标记它，最短路径为已知
                    queue.enqueue(w); //入队
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if(!marked[v]) {
            return null;
        }
        Stack<Integer>  path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
