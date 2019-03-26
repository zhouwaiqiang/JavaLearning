package com.zhou.primMST;

import com.zhou.datastructure.Bag;
import com.zhou.datastructure.IndexMinPQ;

/**
 * Created by 强 on 2018/7/17.
 */
public class PrimMST {
    private Edge[] edgeTo; //距离树最近的边
    private double[] distTo; //distTo[w] = edgeTo[w].weight()
    private boolean[] marked; //如果v在树中则为true
    private IndexMinPQ<Double> pq;//有效的横切边

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<Double>(G.V());
        distTo[0] = 0.0;
        pq.insert(0, 0.0);//用顶点0和权重0.0初始化pq
        while(!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);

            if (marked[w]) {
                continue;
            }
            if (e.weight() < distTo[w]) {
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<Edge>();
        return b;
    }

    public double weight() {
        return weight();
    }

}
