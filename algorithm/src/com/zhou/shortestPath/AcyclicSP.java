package com.zhou.shortestPath;

import com.zhou.datastructure.Stack;
import com.zhou.graph.DirectedEdge;
import com.zhou.graph.Topological;
import com.zhou.primMST.EdgeWeightedGraph;

/**
 * Created by 强 on 2018/7/17.
 */
public class AcyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    public AcyclicSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        Topological top = new Topological(G);
        for (int v : top.order()) {
            relax(G, v);
        }
    }
    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if(distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge x = edgeTo[v]; x != null; x = edgeTo[x.to()]) {
            path.push(x);
        }
        return path;
    }
}
