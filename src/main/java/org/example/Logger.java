package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

public class Logger {
    //static so that i can say later:
        //Logger.save(board, fileName);
        //TicTacBoard board = Logger.load(fileName);

    //goal: save a tictactoe board to a file for future loading
    /*
    delimit the rows with /n characters
    delimit the data with $
     */
    public static boolean save(TicTacBoard board, String fileName){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            String[][] grid = board.getBoard();
            for (String[] row : grid){
                for (int j = 0; j<grid.length; j++){
                    String currSpot = row[j];
                    if (currSpot == null){
                        currSpot = "_";
                    }
                    writer.write(currSpot + ",");
                }
                writer.write("\n");
            }
            writer.close();
            return true;
        } catch (IOException e){
            System.out.println("ERROR SAVING FILE");
            return false;
        }
    } //ends saver

    public static TicTacBoard load(String fileName){
        try {
            Path filePath = Path.of(fileName);
            String fileContents = Files.readString(filePath);
            String[] rows = fileContents.split("\n");
            //an array of each row
            int sizeOfBoard = rows.length;
            TicTacBoard board = new TicTacBoard(sizeOfBoard);
            for (int i = 0; i<sizeOfBoard; i++){
                String[] data = rows[i].split(",");
                for (int j = 0; j<sizeOfBoard; j++){
                    String currSpot = data[j];
                    if (!currSpot.equalsIgnoreCase("_")){
                        board.makeMove(i , j , currSpot);
                    }
                }
            }
            return board;
        } catch (IOException e){
            System.out.println("ERROR LOADING FILE");
            return new TicTacBoard(3);

        }
    }
}
