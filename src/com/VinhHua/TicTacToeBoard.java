package com.VinhHua;

import java.util.Random;

public class TicTacToeBoard {
    private char[][] board;
    private Random rand;
    private boolean gameInProgress = true;

    public TicTacToeBoard() {
        board = new char[3][3];
        rand = new Random();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    } // end default constructor

    /**
     * Prints the game board.
     */
    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
        System.out.println();

    }

    /**
     * Get first turn, if 0 computer goes first, 1 user goes first
     * @return either 0 or 1.
     */
    public int getFirstTurn(){
        return rand.nextInt(2);
    }

    /**
     * Check whether the user input from main method is valid.
     */
    public boolean getUserInput(int row, int col) {
        if (!isValidMove(row, col)) {
            return false;

        } else {
            if (gameInProgress) {
                System.out.println("User placed an x on row " + row + ", column " +col);
                board[row][col] = 'x';
                if (isGameOver()){
                    gameInProgress = false;
                    System.out.println("You won!");
                }
            }
            return true;
        }

    }


    /**
     * This method takes a random generated move from computer and place it on the board.
     */
    public void getComputerMove() {
        // If game is still in progress then keeps going.
        while (gameInProgress) {
            int row = rand.nextInt(3);
            int col = rand.nextInt(3);
            if (isValidMove(row, col)) {
                System.out.println("Computer placed an O on row " + row + ", column " + col);
                board[row][col] = 'o';
                // If winning condition is met then change the state of the game.
                if (isGameOver()) {
                    // change it to false.
                    gameInProgress = false;
                    System.out.println("Computer won!!!");
                }
                break;
            }
        }

    }


    /**
     * This method checks if the game winning conditions is met.
     * @return true if 3 consecutive chars met horizontally, vertically or diagonally, false if otherwise.
     */
    public boolean isGameOver() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    /**
     * Check if the move is valid or not.
     * @param row the row that from the user, computer
     * @param col the column from the user, computer
     * @return true if move is valid, false if not.
     */
    public boolean isValidMove(int row, int col) {
        if (board[row][col] == '-')
            return true;
        else
            return false;

    }

    /**
     * Check if 3 consecutive characters are on the same row.
     * @return true if the condition is met, false if otherwise.
     */
    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-')
                return true;
        }
        return false;
    }

    /**
     * Check if 3 consecutive characters are on the same column.
     * @return true if the condition is met, false if otherwise.
     */
    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-')
                return true;
        }
        return false;
    }

    /**
     * Check if 3 consecutive characters are on the align diaginolly.
     * @return true if the condition is met, false if otherwise.
     */
    private boolean checkDiagonals() {
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != '-')
            return true;

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != '-')
            return true;

        return false;
    }

}
