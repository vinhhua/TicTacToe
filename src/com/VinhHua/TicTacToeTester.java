package com.VinhHua;

import java.util.Scanner;

public class TicTacToeTester {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        TicTacToeBoard game = new TicTacToeBoard();
        if (game.getFirstTurn() == 0) {
            System.out.println("Computer goes first.");
            // If random generated a 0 then computer goes first
            game.getComputerMove();
        } else {
            System.out.println("User goes first.");
            getUserInput(game);
        }
        do {
            getUserInput(game);

        } while (!game.isGameOver());
        game.printBoard();

    }

    /**
     * Take user input and then pass it the other method in TicTacToeBoard to validate the move.
     * @param game to access the method getUserInput.
     */
    public static void getUserInput(TicTacToeBoard game) {
        game.printBoard();
        System.out.println("Enter row and column (In range of 0 to 2): ");
        int row = scan.nextInt();
        int col = scan.nextInt();
        if(!game.getUserInput(row, col)){
            System.out.println("Enter invalid, please try another position");
        }else{
            game.getComputerMove();
        }
    }

}
