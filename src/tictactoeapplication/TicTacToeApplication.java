package tictactoeapplication;

import java.util.Scanner;

/**
 *
 * @author Rakesh
 */
public class TicTacToeApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Getting input from user
        Scanner sc = new Scanner(System.in);
        
        boolean Play = true; //For user to play 
        
        while(Play){
            System.out.println("Welcome to TicTacToe. Pick a Character");
            System.out.println();
            char playerToken = sc.next().charAt(0);
            System.out.println("Enter a single character that will represent you opponent on the board");
            char opponentToken = sc.next().charAt(0);
            TicTacToe game = new TicTacToe(playerToken,opponentToken);
            AI ai = new AI();
            
            //Setup game
            System.out.println();
            System.out.println("Now we can stat the game. To play enter a number and your token shall be put in its place"
            +" \n The number go from 1-9, left to right.");
            TicTacToe.printIndexBoard();
            System.out.println();
            //Play
            while(game.gameOver().equals("notOver")){
                if(game.currentMarker == game.player){
                    //User Turn
                    System.out.println("It's your turn! Enter a spot for your place");
                    int spot = sc.nextInt();
                    while (!game.playTurn(spot)){
                        System.out.println("Try Again" + spot + "is invalid. This spot is already taken or out of Range");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked" + spot + "!");
                }else {
                    //AI turn
                    System.out.println("Its my Turn");
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked "+ aiSpot + "!");
                }
                //Print out the board
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            //Setup a new game ... if user wants to play
            System.out.println("Do you want to play game again Enter Y to play otherwise enter anything else");
            char response = sc.next().charAt(0);
            Play = (response == 'Y'|| response =='y');
            System.out.println();
        }
    }
}
