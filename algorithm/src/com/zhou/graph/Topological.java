package com.zhou.graph;

import com.zhou.shortestPath.EdgeWeightedDigraph;

/**
 * Created by 强 on 2018/6/11.
 */
//拓扑排序
public class Topological {
    private Iterable<Integer> order;//顶点的拓扑顺序
    public Topological(Digraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Topological(EdgeWeightedDigraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    private boolean isDAG() {
        return order != null;
    }

    public static void main(String[] args){
        String filename = args[0];
        String separator = args[1];
    }

}
