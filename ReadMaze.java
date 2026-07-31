import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadMaze 
{
    public MazeGrid readMaze(String filename) 
    {
        MazeGrid maze = null;

        try 
        {
            File file = new File(filename);
            Scanner s = new Scanner(file);

            int rows = s.nextInt();
            int columns = s.nextInt();
            s.nextLine();

            maze = new MazeGrid(rows, columns);

            for (int i = 0; i < rows; i++) 
            {
                String line = s.nextLine();

                for (int j = 0; j < columns; j++) 
                {
                    char type = line.charAt(j);

                    Cell cell = new Cell(i, j, type);

                    maze.setCell(i, j, cell);
                }
            }

            s.close();
        } 

        catch (FileNotFoundException error) 
        {
            System.out.println("Maze file not found.");
        }

        return maze;
    }
}
