package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        /*
        Tic Tac Toe
        Objects we'll need:

        Play Class
            Initialize Players(determine 2 players or 1vsCOM
            Turn tracker >> boolean
            Main method
                While Loop
        Player Class
            Symbol(x or o)
            PutOnBoard(board object)
            SUBCLASS: ComputerPlayer
                PutOnBoard(board object)
                    randomly chooses an open spot

        Board Class
            constructor
                new game
                load old game
            Grid of spots
            2D array of Strings
            makeMove(row, col, symbol)
            displayBoard(method)
                toString()
                DisplayWithLabels()
            determineWinner(){
            p1 wins
            p2 wins
            draw
            }
            result enum
                P1_WINS
                P2_WINS
                DRAW
                KEEP_PLAYING

         Saver/loader class
            static methods:
                save(board)
                    user input the file name
                load(read in the file and return a populated board)
         */
    }
}