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

    public int getTotalSteps() {
        return this.totalSteps;
    }

    public long getExecutionTime() {
        return this.executionTime;
    }

    


    // search algo 
   
}
