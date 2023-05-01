package org.example;

import java.util.Scanner;

public class Player {
    private String symbol;
    public Player(String symbol){
        this.symbol = symbol;
    }

    //putOnBoard
    public void putOnBoard(TicTacBoard board){
        int row = -1 , col = -1;
        Scanner scan = new Scanner(System.in);
        do {

            System.out.print("Enter your row: ");
            String rowResponse = scan.nextLine();
            try {
                row = Integer.parseInt(rowResponse);
            } catch (NumberFormatException e){
                System.out.println("\nPlease provide actual input: ");
            }
            System.out.println();
            System.out.print("Thanks. Enter your column: ");
            String colResponse = scan.nextLine();
            try {
                col = Integer.parseInt(colResponse);
            } catch (NumberFormatException e){
                System.out.println("\nPlease provide actual input: ");
            }

        } while (row < 0 || col < 0 || row >= board.getSize() || col >= board.getSize()); {

            //GOAL : make a move, but lose a turn if the spot is taken

            try {
                board.makeMove(row, col, symbol);
            } catch (SpotsTakenException e) {
                System.out.println(e.getMessage());
                System.out.println("Dank Farrik. you lose a turn :|");
            }

        }
    }

}
