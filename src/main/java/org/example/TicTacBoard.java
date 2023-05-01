package org.example;

public class TicTacBoard {
    //properties
    private String[][] grid;

    //constructors
    public TicTacBoard(int size){
        grid = new String[size][size];
    }
    //methods
    public int getSize(){
        return grid.length;
    }

    public String[][] getBoard(){
        return grid;
    }

    //GOAL: take in row, col, symbol, and put it in the grid
    /*
        what if row/col are out of bounds?
            job of player
        what if there's already a symbol at said row/col
            throw a SpotsTaken exception >> penalty loss of turn
        whose job is it to test those things?
         */
        /*
        we create an isValidSpot(row, col) >> returns a boolean
        when a player is asked for their spot, check it with isValidSpot()
        Valid >> inBounds
        While (!Valid) -> keep asking

        Precondition: that the row/col is valid

        SpotsTaken exception?
         */
    public void makeMove(int row, int col, String symbol){
        if (grid[row][col] == null){
            grid[row][col] = symbol;
        } else {
            throw new SpotsTakenException(row, col, grid[row][col]);
        }
    }

    public void displayWithLabels(){
        System.out.print("    ");
        for (int i =0; i<grid.length; i++){
            System.out.print(i + "   ");

        }

//        System.out.println("._._._._._._.");
        System.out.println();
        int counter = 0;
        for (String[] row : grid){
            System.out.print(counter++);
            System.out.print(" | ");
            for (String spot : row) {
                if (spot == null) {
                    System.out.print("_" + " | ");
                } else {
                    System.out.print(spot + " | ");
                }
            }
            System.out.println();
        }
//        System.out.println("._._._._._._.");
    }

    public Result determineWinner(){
        //P1 >> x
        //P2 >> o

        for (int i = 0 ; i<grid.length; i++){
            int countX = 0;
            int countO = 0;
            for (int j = 0; j<grid.length; j++){
                String spot = grid[i][j];
                if(spot != null && spot.equalsIgnoreCase("X")){
                    countX++;
                } else if (spot != null && spot.equalsIgnoreCase("O"));
            }
            if (countX == grid.length){
                return Result.P1_WINS;
            } else if (countO == grid.length){
                return Result.P2_WINS;
            }
        }

        //column checker
        for (int j = 0 ; j<grid.length; j++){
            int countX = 0;
            int countO = 0;
            for (int i = 0; i<grid.length; i++){
                String spot = grid[i][j];
                if(spot != null && spot.equalsIgnoreCase("X")){
                    countX++;
                } else if (spot != null && spot.equalsIgnoreCase("O")){
                    countO++;
                }
            }
            if (countX == grid.length){
                return Result.P1_WINS;
            } else if (countO == grid.length){
                return Result.P2_WINS;
            }
        }

        //MAJOR DIAGONAL CHECK
        int countX = 0;
        int countO = 0;
        for (int i = 0; i<grid.length; i++){
            String spot = grid[i][i];
            if (spot != null && spot.equalsIgnoreCase("x")){
                countX++;
            } else if (spot!= null && spot.equalsIgnoreCase("o")){
                countO++;
            }
        }
        if (countX == grid.length){
            return Result.P1_WINS;
        } else if (countO == grid.length){
            return Result.P2_WINS;
        }

        //MINOR checker
        countX = 0;
        countO = 0;
        for (int i = 0; i<grid.length; i++){
            String spot = grid[i][grid.length - i - 1];
            if (spot != null && spot.equalsIgnoreCase("x")){
                countX++;
            } else if (spot!= null && spot.equalsIgnoreCase("o")){
                countO++;
            }
        }
        if (countX == grid.length){
            return Result.P1_WINS;
        } else if (countO == grid.length){
            return Result.P2_WINS;
        }

        for (String[] row : grid){
            for (String spot : row){
                if (spot == null){
                    return Result.KEEP_GOING;
                }
            }
        }
        return Result.TIE;
    }

    public static void main(String[] args) {
        TicTacBoard board = new TicTacBoard(3);
        board.makeMove(0,2,"o");
        board.makeMove(1,1,"o");
        board.makeMove(2,0,"x");
        board.displayWithLabels();
        System.out.println(board.determineWinner());
        Logger.save(board,"save.txt");

        System.out.println("Loading your game: ");
        System.out.println();
        TicTacBoard loaded = Logger.load("save.txt");
        loaded.displayWithLabels();
        loaded.makeMove(0,0,"x");
        loaded.displayWithLabels();
    }
}
