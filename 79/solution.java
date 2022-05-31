// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

// Example 1:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
 

// Constraints:

// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (dfs(i, j, 0, word, board, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, int index, String word, char[][] board, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        
        if (i >= m || j >= n || i < 0 || j < 0) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        
        visited[i][j] = true;
        if (index == word.length() - 1) {
            return true;
        }
        
        if (dfs(i + 1, j, index + 1, word, board, visited)) {
            return true;
        }
        if (dfs(i - 1, j, index + 1, word, board, visited)) {
            return true;
        }
        if (dfs(i, j + 1, index + 1, word, board, visited)) {
            return true;
        }
        if (dfs(i, j - 1, index + 1, word, board, visited)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}