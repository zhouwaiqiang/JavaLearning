package com.zhou.shortestPath;

import com.zhou.graph.DirectedEdge;

/**
 * Created by 强 on 2018/7/17.
 */
public class DijkstraAllPairsSP {
    private DijkstraSP[] all;//存储所有地杰斯特最短路径的算法
    public DijkstraAllPairsSP(EdgeWeightedDigraph G) {
        all = new DijkstraSP[G.V()];
        for (int i = 0; i < G.V(); i++) {
            all[i]  = new DijkstraSP(G, i);
        }
    }

    public Iterable<DirectedEdge> path(int s, int t) {
        return all[s].pathTo(t);
    }

    public double dist(int s, int t) {
        return all[s].distTo(t);
    }
}
