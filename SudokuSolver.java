import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class SudokuSolver{
    public static void main(String[] args)throws IOException{
        System.out.println("Welcome to the Sudoku Solver!");
        System.out.print("Please enter the file name that you want to solve:");
        Scanner scan=new Scanner(System.in);
        String fileName= scan.next();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int[][] board = new int[9][9];
        for(int i=0;i<9;i++){
            String[] line = reader.readLine().split(" ");
            for(int j=0;j<9;j++){
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        Sudoku sudoku = new Sudoku(board);
        System.out.println("The original board is:");
        sudoku.printBoard();
        long startTime = System.currentTimeMillis();
        sudoku.solve(sudoku.getBoard());
        long endTime = System.currentTimeMillis();
        System.out.println("The solved board is:");

        sudoku.printBoard();
        
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed Time: " + elapsedTime + " milliseconds");
        scan.close();
        reader.close();
    }
}