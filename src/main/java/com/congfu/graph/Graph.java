/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.graph;


import com.congfu.sort.Bag;
import com.fasterxml.jackson.databind.ser.std.InetSocketAddressSerializer;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author fucong
 * @version $Id Graph.java, v 0.1 2017-03-15 下午10:16 fucong Exp $$
 */
public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private  int V ; // 顶点数目

    private int E;           //边的数目

    private Bag<Integer> [] adj;  //邻边表

    public Graph(int V){
        if (V<0) throw new  IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v]  = new Bag<Integer>();
        }
    }

    public Graph(Graph graph){
        this(graph.V());
        this.E = graph.E();
        for (int v = 0; v < graph.V(); v++){
            //reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : graph.adj[v]){
                reverse.push(w);
            }
            for (int w : reverse){
                adj[v].add(w);
            }
        }
    }

    /**
     *
     * @return the number of vertices in this graph
     */
    public int V(){
        return V;
    }

    /**
     *
     * @return the number of edges in this graph
     */
    public int E(){
        return  E;
    }

    private void validateVertex(int v){
        if (v<0 || v >= V)
            throw new IllegalArgumentException("vertex "+v+" is not between 0 and "+(v-1));
    }

    public void  addEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v){
        validateVertex(v);
        return adj[v].size();
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(V+" vertices, "+E+" edges "+NEWLINE);
        for (int v =0; v < V; v++){
            s.append(v+" : ");
            for (int w : adj[v]){
                s.append(w+" ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static  void main(String [] args){
        Graph graph = new Graph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(0,5);
        graph.addEdge(1,0);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(1,5);
        System.out.println(graph.toString());
    }

}














