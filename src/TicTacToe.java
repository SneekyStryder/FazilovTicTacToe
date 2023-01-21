import java.util.Scanner;

public class TicTacToe
{
    private Player[] players;
    private Board board;
    private int boardConfig;

    /**
     * Creates a player with the symbol X and a player with the symbol O
     * and initializes the players instance variable with the two players.
     *
     * Creates a new Board and assigns it to board, then draws game boad.
     */
    public TicTacToe(int numPlayers, String userBoard)
    {
        if (numPlayers == 2) {
            players = new Player[2];
            players[0] = new Player("X");
            players[1] = new Player("O");
        }
        else if (numPlayers == 3) {
            players = new Player[3];
            players[0] = new Player("X");
            players[1] = new Player("O");
            players[2] = new Player("$");
        }
        else if (numPlayers == 4) {
            players = new Player[4];
            players[0] = new Player("X");
            players[1] = new Player("O");
            players[2] = new Player("$");
            players[3] = new Player("!");
        }
        if (userBoard.equals("3x3")) {
            boardConfig = 3;
        }
        else if (userBoard.equals("4x4")) {
            boardConfig = 4;
        }
        else if (userBoard.equals("5x5")) {
            boardConfig = 5;
        }
        else if (userBoard.equals("6x6")) {
            boardConfig = 6;
        }
        board = new Board(boardConfig);
        board.drawBoard(boardConfig);

    }

    /**
     * A loop will run the game until the board is full.
     * Inside the loop, each player will take a turn, starting with p1/
     * If either player's turn ends the game (the takeTurn() method returns true), break out of the loop.
     */
    public void runGame()
    {
        boolean gameOver = false;

        // repeat until either the board is full (i.e. all spaces have been selected),
        // or the game is over because someone won, which is true if takeTurn returns true
        while (!board.isFull() && !gameOver)
        {
            // each time through the while loop, iterate over the players array (2 players);
            // we add a break just in case the first player in array wins the game,
            // to prevent the next player from getting another turn
            for (int i = 0; i < players.length; i++)
            {
                if(takeTurn(players[i]))
                {
                    gameOver = true;
                    break;  // breaks out of the for-loop -- NOT the while loop
                }
            }
        }
        System.out.println("Thanks for playing!");
    }

    /**
     * Allows the current player to take a turn.
     * Print a message saying whose turn it is: X or O
     * Draw the board for player reference.
     * Allow the appropriate player to enter the space number they want to occupy and record the move.
     * If the player has won the game, print a message and return true.
     * If the board is full, print a message and return true.
     * Otherwise, the game is not yet over and return false.
     *
     * @param player  the player taking the turn.
     * @return  true if the GAME is over, false if the TURN is over but the game is not over
     */
    public boolean takeTurn(Player player)
    {
        Scanner scanner = new Scanner(System.in);
        boolean selectedValidSpace = false;

        // repeat until player selects a valid space, which occurs when recordMove returns true;
        // this occurs when the player has selected a numbered "blank" space.
        while (!selectedValidSpace)
        {
            System.out.print("Player " + player.getSymbol() + "'s turn! Choose a space: ");
            int chosenSpace = scanner.nextInt();
            selectedValidSpace = board.recordMove(chosenSpace, player);
        }

        // redraw the board, which will include the newly placed X or O as updated via recordMove
        board.drawBoard(boardConfig);

        // check to see if the board reveals a winning condition for either X or O
        String winner = board.checkWinner();

        if (!winner.equals(Space.BLANK))
        {
            System.out.println(winner + " won!");
            return true;
        }

        if (board.isFull())
        {
            System.out.println("The game is a tie!");
            return true;
        }

        return false;
    }
}