// Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
 

// Example 1:


// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true
// Example 2:


// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false
 

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0;
        int b = matrix.length - 1;
        int mid = 0;;
        while (t <= b) {
            mid = (t + b) / 2;
            if (matrix[mid][0] > target) {
                b = mid - 1;
            } else if (matrix[mid][0] < target) {
                t = mid + 1;
            } else {
                return true;
            }
        }
        int row = (t + b) / 2;
        int l = 0;
        int r = matrix[row].length - 1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (matrix[row][mid] > target) {
                r = mid - 1;
            } else if (matrix[row][mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}