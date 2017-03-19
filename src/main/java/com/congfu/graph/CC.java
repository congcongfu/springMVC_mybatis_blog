/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.graph;

import com.congfu.baseData.Queue;

/**
 * @author fucong
 * @version $Id CC.java, v 0.1 2017-03-19 下午4:08 fucong Exp $$
 */
public class CC {
    private boolean[] marked;  //marked[v] = has vertex v been marked?
    private int [] id;         // id[v] = id of connected component containing v;
    private int [] size;       // size[id] = number of vertices in given component;
    private int count;         // number of connected components

    public CC(Graph graph){
        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        size = new int[graph.V()];
        for (int v = 0; v < graph.V(); v++){
            if(!marked[v]){
                dfs(graph,v);
                count++;
            }
        }
    }

    private void dfs(Graph graph,int v){
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : graph.adj(v)){
            if (!marked[w]){
                dfs(graph,w);
            }
        }
    }

    public int id(int v){
        return id[v];
    }

    public int size(int v){
        return  size[id[v]];
    }
    public int count(){
        return count;
    }

    public boolean connected(int v, int w){
        return id(v) == id(w);
    }

    public  static  void  main(String [] args){
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        CC cc = new CC(graph);
        int number = cc.count();
        System.out.println(number+" components");
    }
}





















