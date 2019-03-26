package com.zhou.graph;

import com.zhou.datastructure.Bag;
import com.zhou.prepare.In;

/**
 * Created by 强 on 2018/6/3.
 */
public class Graph {
    private final int V;//顶点数目
    private int E;//边的数目
    private Bag<Integer>[] adj; //邻接表
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
    }

    public Graph(In in) {
        this(in.readInt());//读取图并将其初始化
        int E = in.readInt(); //读取E
        for (int i=0;  i < E; i++) {
            //添加一条边
            int v = in.readInt(); //读取一个顶点
            int w = in.readInt(); //读取另一个顶点
            addEdge(v, w);//添加一条连接他们的边
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
