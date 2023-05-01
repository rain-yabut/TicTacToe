package org.example;

public class SpotsTakenException extends RuntimeException {
    public SpotsTakenException(int row, int col, String symbol){
        super("Hey! There's already a " + symbol + " at " + row + ", " + col);


    }
}
