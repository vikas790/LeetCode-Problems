class Solution {
  
    // Restores the matrix given the sum of every row and every column.
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        // Get the number of rows and columns from the size of the passed arrays
        int rowCount = rowSum.length;
        int colCount = colSum.length;
      
        // Initialize the matrix to return
        int[][] restoredMatrix = new int[rowCount][colCount];

        // Iterate over each cell in the matrix to calculate its value
        for (int row = 0; row < rowCount; ++row) {
            for (int col = 0; col < colCount; ++col) {
                // Determine the minimum value to satisfy both rowSum and colSum constraints
                int value = Math.min(rowSum[row], colSum[col]);
                restoredMatrix[row][col] = value;
              
                // After setting the value for restoredMatrix[row][col], subtract it from 
                // the corresponding rowSum and colSum to maintain the sum constraints
                rowSum[row] -= value;
                colSum[col] -= value;
            }
        }
        // Return the restored matrix that matches the given row and column sums
        return restoredMatrix;
    }
}
