// There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

// The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

// The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

// Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

 

// Example 1:


// Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
// Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// Example 2:

// Input: heights = [[2,1],[1,2]]
// Output: [[0,0],[0,1],[1,0],[1,1]]
 

// Constraints:

// m == heights.length
// n == heights[r].length
// 1 <= m, n <= 200
// 0 <= heights[r][c] <= 105

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            dfs(row, 0, heights[row][0], pac, heights);
            dfs(row, n - 1, heights[row][n - 1], atl, heights);
        }
        for (int col = 0; col < n; col++) {
            dfs(0, col, heights[0][col], pac, heights);
            dfs(m - 1, col, heights[m - 1][col], atl, heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    res.add(l);
                }
            }
        }
        return res;
    }
    private void dfs (int i, int j, int prevHeight, boolean[][] set, int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || prevHeight > heights[i][j] || set[i][j]) {
            return;
        }
        set[i][j] = true;
        dfs(i - 1, j, heights[i][j], set, heights);
        dfs(i + 1, j, heights[i][j], set, heights);
        dfs(i, j - 1, heights[i][j], set, heights);
        dfs(i, j + 1, heights[i][j], set, heights);
    }
}