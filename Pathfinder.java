public class PathFinder
{
    private int totalSteps;
    private int pathLength;
    private double executionTime;
    private boolean pathFound;

    public PathFinder()
    {
        this.totalSteps = 0;
        this.pathLength = 0;
        this.executionTime = 0.0;
        this.pathFound = false;
    }

    public boolean solveDFS(MazeGrid maze, UserInterface ui, int delayMilliseconds)
    {
        this.totalSteps = 0;
        this.pathLength = 0;
        this.executionTime = 0.0;
        this.pathFound = false;
        maze.resetSearchState();

        boolean found = false;
        long algorithmNanoseconds = 0L;
        Stack<Cell> stack = new Stack<Cell>();
        Cell start = maze.getStart();
        Cell goal = maze.getGoal();

        if (start != null && goal != null)
        {
            long stepStartTime = System.nanoTime();
            stack.push(start);
            start.setVisited(true);
            this.totalSteps = 1;
            long stepEndTime = System.nanoTime();
            algorithmNanoseconds += stepEndTime - stepStartTime;

            ui.animateStep(maze, start, delayMilliseconds);
        }

        while (!stack.isEmpty() && !found)
        {
            long stepStartTime = System.nanoTime();
            Cell current = stack.peek();
            Cell displayedCell = current;

            if (current.getType() == 'G')
            {
                found = true;
            }
            else
            {
                Cell neighbor = getUnvisitedNeighbor(maze, current);

                if (neighbor != null)
                {
                    neighbor.setVisited(true);
                    stack.push(neighbor);
                    this.totalSteps++;
                    displayedCell = neighbor;
                }
                else
                {
                    current.setBacktracked(true);
                    stack.pop();
                    displayedCell = stack.peek();
                }
            }

            long stepEndTime = System.nanoTime();
            algorithmNanoseconds += stepEndTime - stepStartTime;

            if (!found)
            {
                ui.animateStep(maze, displayedCell, delayMilliseconds);
            }
        }

        if (found)
        {
            this.pathLength = stack.getCount() - 1;

            while (!stack.isEmpty())
            {
                Cell pathCell = stack.pop();
                pathCell.setSolutionPath(true);
            }
        }

        this.pathFound = found;
        this.executionTime = algorithmNanoseconds / 1000000.0;

        return found;
    }

    private Cell getUnvisitedNeighbor(MazeGrid maze, Cell current)
    {
        int x = current.getX();
        int y = current.getY();
        Cell neighbor = null;
        boolean found = false;

        if (!found && x - 1 >= 0)
        {
            Cell up = maze.getCell(x - 1, y);

            if (up.getType() != '#' && !up.isVisited())
            {
                neighbor = up;
                found = true;
            }
        }

        if (!found && x + 1 < maze.getRows())
        {
            Cell down = maze.getCell(x + 1, y);

            if (down.getType() != '#' && !down.isVisited())
            {
                neighbor = down;
                found = true;
            }
        }

        if (!found && y - 1 >= 0)
        {
            Cell left = maze.getCell(x, y - 1);

            if (left.getType() != '#' && !left.isVisited())
            {
                neighbor = left;
                found = true;
            }
        }

        if (!found && y + 1 < maze.getCols())
        {
            Cell right = maze.getCell(x, y + 1);

            if (right.getType() != '#' && !right.isVisited())
            {
                neighbor = right;
                found = true;
            }
        }

        return neighbor;
    }

    public int getTotalSteps()
    {
        return this.totalSteps;
    }

    public int getPathLength()
    {
        return this.pathLength;
    }

    public double getExecutionTime()
    {
        return this.executionTime;
    }

    public boolean isPathFound()
    {
        return this.pathFound;
    }
}
