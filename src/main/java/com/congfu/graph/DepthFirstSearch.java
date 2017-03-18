/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.graph;

/**
 * @author fucong
 * @version $Id DepthFirstSearch.java, v 0.1 2017-03-16 下午10:44 fucong Exp $$
 */
public class DepthFirstSearch {

    private boolean [] marked;
    private int count;

    public DepthFirstSearch(Graph G,int s){
        marked = new boolean[G.V()];
        dfs(G,s);

    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        count++;
        for (int w : G.adj(v)){
            if (!marked[w]){
                dfs(G,w);
            }
        }
    }

    public boolean marked(int w){
        return marked[w];
    }
    public int count(){
        return count;
    }
}
