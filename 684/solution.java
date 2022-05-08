// In this problem, a tree is an undirected graph that is connected and has no cycles.

// You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

// Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

 

// Example 1:


// Input: edges = [[1,2],[1,3],[2,3]]
// Output: [2,3]
// Example 2:


// Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
// Output: [1,4]
 

// Constraints:

// n == edges.length
// 3 <= n <= 1000
// edges[i].length == 2
// 1 <= ai < bi <= edges.length
// ai != bi
// There are no repeated edges.
// The given graph is connected.

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind set= new UnionFind(n);
        
        for (int[] edge : edges) {
            int in = edge[0];
            int out = edge[1];
            if (set.find(in) == set.find(out)) {
                return edge;
            }
            set.union(in, out);
        }
        return new int[] {0, 0};
    }
    
    class DisjointSet {
        private int[] par;
        private int[] rank;
        
        public UnionFind(int size) {
            par = new int[size + 1];
            for (int i = 1; i < size + 1; i++) {
                par[i] = i;
            }
            rank = new int[size + 1];
            Arrays.fill(rank, 1);
        }
        
        public int find(int v) {
            int cur = v;
            if (par[v] != v) {
                cur = find(par[v]);
            }
            par[v] = cur;
            return par[v];
        }
        
        public void union(int v, int w) {
            v = find(v);
            w = find(w);
            if (rank[v] > rank[w]) {
                rank[v] += rank[w];
                par[w] = v;
            } else {
                rank[w] += rank[w];
                par[v] = w;
            }
        }
    }
}