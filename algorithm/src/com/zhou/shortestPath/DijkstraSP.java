package com.zhou.shortestPath;

import com.zhou.datastructure.Stack;
import com.zhou.graph.DirectedEdge;
import com.zhou.datastructure.IndexMinPQ;

/**
 * Created by 强 on 2018/7/10.
 */
public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        //初始化各个变量
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];//源点到各个顶点的最短距离，默认设置为无穷大
        for (int i = 0; i < G.V(); i++){
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        pq = new IndexMinPQ<Double>(G.V());
        pq.insert(s, 0.0);
        while(!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    public double distTo(int v) {
        //从顶点s到v的距离，如果不存在则路径为无穷大
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge x = edgeTo[v]; x != null; x = edgeTo[x.from()]) {
            path.push(x);
        }
        return path;
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }
}
