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

        // TODO: Implement Stack-based DFS here
        long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;

        return found;
    }


    private Cell getUnvisitedNeighbor(MazeGride maze, Cell current) {
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

        
    }
    
    public int getTotalSteps() {
        return this.totalSteps;
    }

    public long getExecutionTime() {
        return this.executionTime;
    }

    


    // search algo 
   
}
