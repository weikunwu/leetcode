// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

// The area of an island is the number of cells with a value 1 in the island.

// Return the maximum area of an island in grid. If there is no island, return 0.

 

// Example 1:


// Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
// Output: 6
// Explanation: The answer is not 11, because the island must be connected 4-directionally.
// Example 2:

// Input: grid = [[0,0,0,0,0,0,0,0]]
// Output: 0
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// grid[i][j] is either 0 or 1.

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int a = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    a = Math.max(a, bfs(i, j, grid));
                }
            }
        }
        return a;
    }
    
    private int bfs(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        ArrayList<int[]> queue = new ArrayList<>();
        
        queue.add(new int[] {i, j});
        grid[i][j] = 0;
        int[][] directions = new int[4][2];
        directions[0] = new int[] {-1, 0};
        directions[1] = new int[] {1, 0};
        directions[2] = new int[] {0, -1};
        directions[3] = new int[] {0, 1};
        
        int area = 0;
        while (!queue.isEmpty()) {
            int[] index = queue.remove(0);
            area++;
            int r = index[0];
            int c = index[1];

            for (int[] dir:directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n
                    || grid[nr][nc] == 0) {
                    continue;
                }
                queue.add(new int[] {nr, nc});
                grid[nr][nc] = 0;
            }
        }
        return area;
    }
}