// Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

// A region is captured by flipping all 'O's into 'X's in that surrounded region.

 

// Example 1:


// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
// Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
// Example 2:

// Input: board = [["X"]]
// Output: [["X"]]
 

// Constraints:

// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] is 'X' or 'O'.

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            dfs(row, 0, board, visited);
            dfs(row, n - 1, board, visited);
        }
        for (int col = 0; col < n; col++) {
            dfs(0, col, board, visited);
            dfs(m - 1, col, board, visited);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(int i, int j, char[][] board, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(i - 1, j, board, visited);
        dfs(i + 1, j, board, visited);
        dfs(i, j - 1, board, visited);
        dfs(i, j + 1, board, visited);
    }
}