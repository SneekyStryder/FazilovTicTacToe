import java.util.Scanner;
public class Main
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many players? (2, 3, or 4): ");
        int userChoice = scan.nextInt();
        TicTacToe ticTacToe = new TicTacToe(userChoice);
        ticTacToe.runGame();
    }
}