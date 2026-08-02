public class Pathfinder 
{
    private int totalSteps;
    private int pathLength;
    private long executionTime;
    private boolean pathFound;

    public Pathfinder() {
        this.totalSteps = 0;
        this.pathLength = 0;
        this.executionTime = 0;
        this.pathFound = false;
    }

    public boolean solveDFS(MazeGrid maze) {
        boolean found = false;
        long startTime = System.currentTimeMillis();

        Stack<Cell> stack = new Stack<Cell>();
        Cell start = maze.getStart();

        if (start != null) {
            stack.push(start);
            start.setVisited(true);
        }

        while (!stack.isEmpty() && !found) {
            Cell current = stack.peek();
            this.totalSteps++;

            if (current.getType() == 'G') {
                found = true;
            }
            else {
                Cell neighbor = getUnvisitedNeighbor(maze, current);

                if (neighbor != null) {
                    neighbor.setVisited(true);
                    stack.push(neighbor);
                }
                else {
                    stack.pop();
                }
            }
        }

        long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;
        this.pathLength = stack.getCount();
        
        return found;
    }


    private Cell getUnvisitedNeighbor(MazeGrid maze, Cell current) {
        int x = current.getX();
        int y = current.getY();
        Cell neighbor = null;
        boolean found = false;

        if (!found && x - 1 >= 0) {
            Cell up = maze.getCell(x - 1, y);
            if (up != null && up.getType() != '#' && !up.isVisited()) {
                neighbor = up;
                found = true;
            }
        }

        if (!found && x + 1 < maze.getRows()) {
            Cell down = maze.getCell(x + 1, y);
            if (down != null && down.getType() != '#' && !down.isVisited()) {
                neighbor = down;
                found = true;
            }
        }
        
        if (!found && y - 1 >= 0) {
            Cell left = maze.getCell(x, y - 1);
            if (left != null && left.getType() != '#' && !left.isVisited()) {
                neighbor = left;
                found = true;
            }
        }

        if (!found && y + 1 < maze.getCols()) {
            Cell right = maze.getCell(x, y + 1);
            if (right != null && right.getType() != '#' && !right.isVisited()) {
                neighbor = right;
                found = true;
            }
        }
        return neighbor;
    }
    
    public int getTotalSteps() {
        return this.totalSteps;
    }

    public long getExecutionTime() {
        return this.executionTime;
    }

    


    // search algo 
   
}
