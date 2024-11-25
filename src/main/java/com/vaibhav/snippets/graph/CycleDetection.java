package com.vaibhav.snippets.graph;

import java.util.*;

public class CycleDetection {

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        Set<Integer> nodes = new HashSet<>();

        //   for(ArrayList<Integer> neighbours : adj) {
        //       for(int node : neighbours) {
        //           nodes.add(node);
        //       }
        //   }

        //   for(int node : nodes) {
        //       if(hasCycle(adj, node)) {
        //           return true;
        //       }
        //   }
        return hasCycleBfdUndirected(adj, 0);
    }

    public boolean hasCycleBfdUndirected(ArrayList<ArrayList<Integer>> adj, int source) {
        Queue<Pair> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        int parent = -1;
        int child = source;

        q.add(new Pair(child, parent));

        while(!q.isEmpty()) {
            parent = q.peek().parent;
            child = q.peek().child;
            q.poll();
            vis.add(child);

            for(int neighbour : adj.get(child)) {
                if(!vis.contains(neighbour)) {
                    q.add(new Pair(neighbour, child));
                } else if(neighbour != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    class Pair {
        int child;
        int parent;
        Pair(int child, int parent) {
            this.child = child;
            this.parent = parent;
        }
    }

    public boolean hasCycleDfsUndirected(ArrayList<ArrayList<Integer>> adj) {
        Set<Integer> nodes = new HashSet<>();
        for(ArrayList<Integer> neighbours : adj) {
            for(int node : neighbours) {
                nodes.add(node);
            }
        }

        Set<Integer> vis = new HashSet<>();

        for(int node : nodes) {
            if(!vis.contains(node)) {
                if (dfs(node, -1, vis, adj) == true) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean dfs(int node, int parent, Set<Integer> vis, ArrayList<ArrayList<Integer>> adj) {
        vis.add(node);

        for(int neighbour : adj.get(node)) {
            if(!vis.contains(neighbour)) {
                if(dfs(neighbour, node, vis, adj) == true) {
                    return true;
                }
            } else if(neighbour != parent) {
                return true;
            }
        }

        return false;

    }


    //detect cycle in directed graph using dfs
    public boolean hasCycleDfsDirected(ArrayList<ArrayList<Integer>> adj) {
        Set<Integer> nodes = new HashSet<>();
        for(ArrayList<Integer> neighbours : adj) {
            for(int node : neighbours) {
                nodes.add(node);
            }
        }

        Set<Integer> vis = new HashSet<>();
        Set<Integer> pathVis = new HashSet<>();

        for(int node : nodes) {
            if(!vis.contains(node)) {
                if (dfs(node, vis, pathVis, adj) == true) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean dfs(int node, Set<Integer> vis, Set<Integer> pathVis, ArrayList<ArrayList<Integer>> adj) {
        vis.add(node);
        pathVis.add(node);

        for(int neighbour : adj.get(node)) {
            if(!vis.contains(neighbour)) {
                if(dfs(neighbour, vis, pathVis, adj) == true) {
                    return true;
                }
            } if(pathVis.contains(neighbour)) {
                return true;
            }

        }
        pathVis.remove(node);

        return false;

    }
}
