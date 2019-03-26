package com.zhou.primMST;

import com.zhou.datastructure.Bag;
import com.zhou.prepare.In;

/**
 * Created by 强 on 2018/7/9.
 */
public class EdgeWeightedGraph {
    private final int V;//顶点总数
    private int E;//边的总数
    private Bag<Edge>[] adj;//邻接表

    public EdgeWeightedGraph(int V) {
        this.V  = V;
        this.E = 0;
        adj = (Bag<Edge>[])new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge edge = new Edge(v, w, weight);
            this.addEdge(edge);
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {
                    b.add(e);
                }
            }
        }
        return b;
    }
}
