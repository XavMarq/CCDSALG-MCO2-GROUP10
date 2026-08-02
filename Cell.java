public class Cell
{
    private int x;
    private int y;
    private char type;
    private boolean visited;
    private boolean backtracked;
    private boolean solutionPath;

    public Cell(int x, int y, char type)
    {
        this.x = x;
        this.y = y;
        this.type = type;
        this.visited = false;
        this.backtracked = false;
        this.solutionPath = false;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public char getType()
    {
        return this.type;
    }

    public boolean isVisited()
    {
        return this.visited;
    }

    public boolean isBacktracked()
    {
        return this.backtracked;
    }

    public boolean isSolutionPath()
    {
        return this.solutionPath;
    }

    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }

    public void setBacktracked(boolean backtracked)
    {
        this.backtracked = backtracked;
    }

    public void setSolutionPath(boolean solutionPath)
    {
        this.solutionPath = solutionPath;
    }

    public void resetSearchState()
    {
        this.visited = false;
        this.backtracked = false;
        this.solutionPath = false;
    }
}
