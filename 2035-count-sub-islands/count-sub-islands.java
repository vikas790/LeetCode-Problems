public class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length;
        int cols = grid1[0].length;
        int subIslandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            
                if (grid2[i][j] == 1) {
                   
                    if (dfs(grid1, grid2, i, j)) {
                        subIslandCount++;
                    }
                }
            }
        }

        return subIslandCount;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {

        if (i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length || grid2[i][j] == 0) {
            return true;
        }

      
        grid2[i][j] = 0;

        boolean isSubIsland = grid1[i][j] == 1;

        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);

        return isSubIsland && up && down && left && right;
    }
}
