import java.util.Scanner;
public class Main
{
    public static void main(String args[])
    {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        System.out.print("How many players? (2, 3, or 4): ");
        int userChoice = scan1.nextInt();
        System.out.print("Select a board size (3x3, 4x4, 5x5, 6x6): ");
        String userBoardChoice = scan2.nextLine();
        TicTacToe ticTacToe = new TicTacToe(userChoice, userBoardChoice);
        ticTacToe.runGame();
    }
}