import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadMaze
{
    public MazeGrid readMaze(String filename)
    {
        MazeGrid maze = null;
        Scanner fileScanner = null;

        try
        {
            fileScanner = new Scanner(new File(filename));
            int rows = fileScanner.nextInt();
            int columns = fileScanner.nextInt();
            fileScanner.nextLine();

            boolean valid = true;
            int startCount = 0;
            int goalCount = 0;

            if (rows < 15 || rows > 30 || columns < 15 || columns > 30)
            {
                System.out.println("Invalid maze dimensions. Rows and columns must be from 15 to 30.");
                valid = false;
            }

            MazeGrid loadedMaze = null;

            if (valid)
            {
                loadedMaze = new MazeGrid(rows, columns);
            }

            for (int row = 0; row < rows && valid; row++)
            {
                if (fileScanner.hasNextLine())
                {
                    String line = fileScanner.nextLine();

                    if (line.length() != columns)
                    {
                        System.out.println("Invalid maze row length at row " + (row + 1) + ".");
                        valid = false;
                    }
                    else
                    {
                        for (int col = 0; col < columns && valid; col++)
                        {
                            char type = line.charAt(col);

                            if (isAllowedType(type))
                            {
                                Cell cell = new Cell(row, col, type);
                                loadedMaze.setCell(row, col, cell);

                                if (type == 'S')
                                {
                                    startCount++;
                                }
                                else if (type == 'G')
                                {
                                    goalCount++;
                                }
                            }
                            else
                            {
                                int rowNumber = row + 1;
                                int columnNumber = col + 1;
                                System.out.println("Invalid symbol '" + type + "' at row " + rowNumber + ", column " + columnNumber + ".");
                                valid = false;
                            }
                        }
                    }
                }
                else
                {
                    System.out.println("Maze file has fewer rows than expected.");
                    valid = false;
                }
            }

            if (valid && (startCount != 1 || goalCount != 1))
            {
                System.out.println("Maze must contain exactly one S and exactly one G.");
                valid = false;
            }

            if (valid)
            {
                maze = loadedMaze;
            }
        }
        catch (FileNotFoundException error)
        {
            System.out.println("Maze file not found.");
        }
        catch (InputMismatchException error)
        {
            System.out.println("The maze dimensions must be integers.");
        }
        catch (NoSuchElementException error)
        {
            System.out.println("The maze file is incomplete.");
        }
        finally
        {
            if (fileScanner != null)
            {
                fileScanner.close();
            }
        }

        return maze;
    }

    private boolean isAllowedType(char type)
    {
        boolean allowed = false;

        if (type == ' ' || type == '#' || type == 'S' || type == 'G')
        {
            allowed = true;
        }

        return allowed;
    }
}
