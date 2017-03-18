/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.graph;

import java.util.Stack;

/**
 * @author fucong
 * @version $Id DepthFisrtPath.java, v 0.1 2017-03-18 下午2:54 fucong Exp $$
 */
public class DepthFirstPath {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPath(Graph graph, int s) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;
        validateVertex(s);
        dfs(graph, s);
    }


    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    /**
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int i = v; i != s; i = edgeTo[i]) {
            path.push(i);
        }
        path.push(s);
        return path;
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        DepthFirstPath depthFisrtPath = new DepthFirstPath(graph, 0);
        System.out.println(depthFisrtPath.hasPathTo(5));

        Stack<Integer> path = (Stack<Integer>) depthFisrtPath.pathTo(5);
        while (path.size()>0){
            System.out.println(path.pop());
        }
        System.out.println(depthFisrtPath.pathTo(5));
    }

}
