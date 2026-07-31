import java.util.Scanner;

public class UserInterface 
{
    private MazeGrid currentMaze;

    public void startMenu() 
    {
        Scanner s = new Scanner(System.in);
        boolean isActive = true;

        while (isActive) 
        {
            System.out.println("\nMaze Solver");
            System.out.println("1. Load Maze");
            System.out.println("2. Start Simulation");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int choice = s.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.println("Load Maze selected.");
                    break; 
                case 2:
                    System.out.println("Simulation selected.");
                    break;
                case 3:
                    isActive = false; 
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        s.close();
    }

    public void displayMaze(MazeGrid grid) 
    {

    }
}
