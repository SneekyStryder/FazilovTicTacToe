import java.util.Scanner;
public class Main
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many players? (2, 3, or 4): ");
        int userChoice = scan.nextInt();
        System.out.println("Select a board size (3x3, 4x4, 5x5): ");
        String userBoardChoice = scan.nextLine();
        TicTacToe ticTacToe = new TicTacToe(userChoice, userBoardChoice);
        ticTacToe.runGame();
    }
}