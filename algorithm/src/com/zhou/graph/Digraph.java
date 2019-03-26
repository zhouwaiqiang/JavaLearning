package com.zhou.graph;

import com.zhou.datastructure.Bag;

/**
 * Created by 强 on 2018/6/4.
 */
//有向图
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj =  (Bag<Integer>[]) new Bag[V];
        for (int v =  0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int E() {
        return this.E;
    }

    public int V() {
        return this.V;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }
}
