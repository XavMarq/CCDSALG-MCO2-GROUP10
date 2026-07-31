/**
 * Cell class that represents a cell in the maze.
 * Stores its x and y position, type, and visited cells.
 */
public class Cell 
{
    /**
     * Row position of the cell
     */
    private int x;

    /**
     * Column position of the cell
     */
    private int y;

    /**
     * Cell type (' ', '#', 'S', or 'G')
     */
    private char type;

    /**
     * che the cell has been visited.
     */
    private boolean visited;

    /**
     * Constructor that creates a Cell object given its x and y position and type.
     * Initializes the cell's x and y coordinates, type, and sets the initial visited to false;
     *
     * @param x the starting x-coordinate of the cell
     * @param y the starting y-coordinate of the cell
     * @param type the character representing the cell type
     */
    public Cell(int x, int y, char type) 
    {
        this.x = x;
        this.y = y;
        this.type = type;
        this.visited = false;
    }

    /**
     * Getter that retrieves the x-coordinate of the cell
     *
     * @return the x-coordinate of the cell
     */
    public int getX() 
    {
        return this.x;
    }

    /**
     * Getter that retrieves the y-coordinate of the cell
     *
     * @return the y-coordinate of the cell
     */
    public int getY() 
    {
        return this.y;
    }

    /**
     * Getter that retrieves the cell type
     *
     * @return the cell type
     */
    public char getType() 
    {
        return this.type;
    }

    /**
     * Getter that retrieves the visited state of the cell
     *
     * @return true if the cell has been visited; false otherwise
     */
    public boolean isVisited() 
    {
        return this.visited;
    }

    /**
     * Setter that updates the visited state of the cell
     *
     * @param visited the cell's new visited state 
     */
    public void setVisited(boolean visited) 
    {
        this.visited = visited;
    }
}
