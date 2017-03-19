/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.graph;

import com.congfu.baseData.Queue;
import com.congfu.baseData.Stack;

/**
 * @author fucong
 * @version $Id BreadthFirstPaths.java, v 0.1 2017-03-19 下午12:29 fucong Exp $$
 */
public class BreadthFirstPaths {
    private static  final int INFINITY = Integer.MAX_VALUE;
    private  boolean[] marked; //到达该顶点的最短路径已知 吗? marked[v] = is there an s-v path
    private int [] edgeTo;  // 到达该顶点的已知路径的最后一个顶点 edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;   // distTo[v]= number of edges shortest s-v path

    public BreadthFirstPaths(Graph graph , int s){
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        distTo = new int[graph.V()];
        for (int v = 0; v <graph.V();v++){
            distTo[v] = INFINITY;
        }
        bfs(graph,s);
         check(graph,s);

    }

    public BreadthFirstPaths(Graph graph, Iterable<Integer> sources){
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        distTo = new int[graph.V()];
        for (int v = 0; v < graph.V();v++){
            distTo[v] = INFINITY;
        }

    }

    private  void  bfs(Graph graph, int s){
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true;       //标记起点
        queue.enqueue(s);       //将顶点加入队列
        distTo[s] = 0;
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w : graph.adj(v)){
                if (!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    distTo[w] = distTo[v]+1;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)) return  null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0 ;x=edgeTo[x]){
            path.push(x);
        }
        path.push(x);
        return path;
    }

    public int distTo(int v){
        return  distTo[v];
    }

    private boolean check(Graph graph, int s){
        if (distTo[s] !=0){
            System.out.println("distance of source "+s+" to itself = "+distTo[s]);
            return false;
        }
        for (int v = 0; v < graph.V(); v++){
            for (int w : graph.adj(v)){
                if (hasPathTo(v) != hasPathTo(w)){
                    System.out.println("edge "+v+"-"+w);
                    System.out.println("hasPathTo("+v+")= "+hasPathTo(v));
                    System.out.println("hasPathTo("+w+")= "+hasPathTo(w));
                    return false;
                }
                if (hasPathTo(v)&& (distTo[w]>distTo[v]+1)){
                    System.out.println("edge "+v+"-"+w);
                    System.out.println("distTo["+v+"]= "+distTo[v]);
                    System.out.println("distTo["+w+"]= "+distTo[w]);
                    return false;
                }
            }
        }
        for (int w= 0; w <graph.V(); w++){
            if (!hasPathTo(w) || w == s) continue;
            int v = edgeTo[w];
            if (distTo[w] != distTo[v]+1){
                System.out.println("shortest path edge "+v +"-"+w);
                System.out.println("distTo["+v+"] = "+distTo[v] );
                System.out.println("distTo["+w+"] = "+distTo[w]);
                return false;
            }
        }
        return true;

    }



    public static  void  main(String[] args){
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(graph, 0);
        for (int v= 0; v<graph.V(); v++){
            if (breadthFirstPaths.hasPathTo(v)){
                for (int x : breadthFirstPaths.pathTo(v)){
                    if (x ==0) System.out.println(x);
                    else System.out.println("-"+x);
                }
                System.out.println();
            }else {
                System.out.println(0+" to "+v+" not connected");
            }
        }
    }
}






















