class Solution {
    int perimeter = 0;

    public int islandPerimeter(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;

        for(int i = 0; i < rowSize; i++)
        {
            for(int j = 0; j < colSize; j++)
            {
                if(grid[i][j] == 1)
                {
                    perimeter += move(grid, i - 1, j, rowSize, colSize); // Up
                    perimeter += move(grid, i + 1, j, rowSize, colSize); // Down
                    perimeter += move(grid, i, j + 1, rowSize, colSize); // Right
                    perimeter += move(grid, i, j - 1, rowSize, colSize); // Left
                }             
            }
        }

        return perimeter;
    }    

    private int move(int[][] grid, int i,int j, int rowSize, int colSize)
    {
        if(i < 0 || j < 0 || i >= rowSize || j >= colSize)
        {
            return 1;
        }

        if(grid[i][j] == 0)
        {
            return 1;
        }

        return 0;
    }
}
