// You are given a m x n 2D grid initialized with these three possible values.

// -1 - A wall or an obstacle.
// 0 - A gate.
// INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a Gate, that room should remain filled with INF

// Example
// Example1

// Input:
// [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
// Output:
// [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]

// Explanation:
// the 2D grid is:
// INF  -1  0  INF
// INF INF INF  -1
// INF  -1 INF  -1
//   0  -1 INF INF
// the answer is:
//   3  -1   0   1
//   2   2   1  -1
//   1  -1   2  -1
//   0  -1   3   4
// Example2

// Input:
// [[0,-1],[2147483647,2147483647]]
// Output:
// [[0,-1],[1,2]]

public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        boolean[][] visited = new boolean[m][n];
        ArrayList<int[]> queue = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove(0);
                for (int[] dir:dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] <= 0 || visited[r][c]) {
                        continue;
                    }
                    visited[r][c] = true;
                    queue.add(new int[] {r, c});
                    rooms[r][c] = step;
                }
            }
        }
    }
}