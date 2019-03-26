package com.zhou.graph;

import com.zhou.datastructure.Stack;

/**
 * Created by 强 on 2018/6/4.
 */
public class DepthFirstPaths {
    private boolean[] marked;//这个顶点上是否调用过dfs()
    private int[] edgeTo;//从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;//起点

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int s) {
        marked[s]  = true;
        for (int w : G.adj(s)) {
            if (!marked[w]) {
                edgeTo[w] = s;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
