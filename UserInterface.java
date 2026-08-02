import java.util.Scanner;

public class UserInterface
{
    private MazeGrid currentMaze;

    public UserInterface()
    {
        this.currentMaze = null;
    }

    public void startMenu()
    {
        Scanner scanner = new Scanner(System.in);
        boolean isActive = true;

        while (isActive)
        {
            System.out.println("\nMaze Solver");
            System.out.println("1. Load Maze");
            System.out.println("2. Start Simulation");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            String input = scanner.nextLine();
            int choice = parseChoice(input);

            switch (choice)
            {
                case 1:
                    loadMaze(scanner);
                    break;
                case 2:
                    startSimulation();
                    break;
                case 3:
                    isActive = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1, 2, or 3.");
                    break;
            }
        }

        scanner.close();
    }

    private int parseChoice(String input)
    {
        int choice = -1;

        try
        {
            choice = Integer.parseInt(input.trim());
        }
        catch (NumberFormatException error)
        {
            choice = -1;
        }

        return choice;
    }

    private void loadMaze(Scanner scanner)
    {
        System.out.print("Enter maze filename or path: ");
        String filename = scanner.nextLine();
        ReadMaze reader = new ReadMaze();
        MazeGrid loadedMaze = reader.readMaze(filename);

        if (loadedMaze != null)
        {
            this.currentMaze = loadedMaze;
            System.out.println("Maze loaded successfully.");
            displayMaze(this.currentMaze, null);
        }
        else
        {
            System.out.println("Maze was not loaded.");
        }
    }

    private void startSimulation()
    {
        if (this.currentMaze == null)
        {
            System.out.println("Load a maze before starting the simulation.");
        }
        else
        {
            PathFinder pathFinder = new PathFinder();
            int delayMilliseconds = 100;
            boolean found = pathFinder.solveDFS(this.currentMaze, this, delayMilliseconds);

            clearScreen();
            displayMaze(this.currentMaze, null);

            if (found)
            {
                System.out.println("\nPath found.");
            }
            else
            {
                System.out.println("\nNo valid path exists.");
            }

            System.out.println("Cells explored: " + pathFinder.getTotalSteps());
            System.out.println("Final path length: " + pathFinder.getPathLength());
            System.out.printf("Execution time: %.3f ms%n", pathFinder.getExecutionTime());
        }
    }

    public void animateStep(MazeGrid grid, Cell current, int delayMilliseconds)
    {
        clearScreen();
        displayMaze(grid, current);
        pause(delayMilliseconds);
    }

    public void displayMaze(MazeGrid grid, Cell current)
    {
        int rowSize = grid.getRows();
        int colummSize = grid.getCols();

        for (int row = 0; row < rowSize; row++)
        {
            for (int col = 0; col < colummSize; col++)
            {
                Cell cell = grid.getCell(row, col);
                char symbol = getDisplaySymbol(cell, current);
                System.out.print(symbol);
            }

            System.out.println();
        }

        System.out.println("Legend: R = rat, . = explored path, x = backtracked");
    }

    private char getDisplaySymbol(Cell cell, Cell current)
    {
        char symbol = cell.getType();

        if (cell == current)
        {
            symbol = 'R';
        }
        else if (cell.getType() == 'S')
        {
            symbol = 'S';
        }
        else if (cell.getType() == 'G')
        {
            symbol = 'G';
        }
        else if (cell.isBacktracked())
        {
            symbol = 'x';
        }
        else if (cell.isVisited())
        {
            symbol = '.';
        }

        return symbol;
    }

    private void clearScreen()
    {
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
    }

    private void pause(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException error)
        {
            Thread.currentThread().interrupt();
        }
    }
}
