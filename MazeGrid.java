public class MazeGrid
{
    private int rows;
    private int cols;
    private Cell[][] grid;
    private Cell start;
    private Cell goal;

    public MazeGrid(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        this.start = null;
        this.goal = null;
    }

    public Cell getCell(int x, int y)
    {
        return this.grid[x][y];
    }

    public int getRows()
    {
        return this.rows;
    }

    public int getCols()
    {
        return this.cols;
    }

    public Cell getStart()
    {
        return this.start;
    }

    public Cell getGoal()
    {
        return this.goal;
    }

    public void setCell(int x, int y, Cell cell)
    {
        this.grid[x][y] = cell;

        if (cell.getType() == 'S')
        {
            this.start = cell;
        }
        else if (cell.getType() == 'G')
        {
            this.goal = cell;
        }
    }

    public void resetSearchState()
    {
        for (int row = 0; row < this.rows; row++)
        {
            for (int col = 0; col < this.cols; col++)
            {
                this.grid[row][col].resetSearchState();
            }
        }
    }
}
