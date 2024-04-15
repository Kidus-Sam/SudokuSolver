public class Sudoku {
    private int[][] board;
    public Sudoku(int[][] board){
        this.board = board;
    }
    public boolean solve(int[][] board) {
        //first lets iterate through the board and check if there are any empty cells
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    //if the cell is empty we will try to fill it with a number from 1 to 9
                    for (int k = 1; k <= 9; k++) {
                        //if the number is safe to place in the cell we will place it
                        if (isSafe(i, j, k)) {
                            board[i][j] = k;
                            //then we will recursively call the solve function to check if the board is solvable
                            if (solve(board)) {
                                return true;
                            }
                            //if the board is not solvable we will backtrack and try a different number
                            else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isSafe(int row, int col, int num){
        //Checking if Number already exists in the row
        for(int i=0;i<9;i++){
            if(board[row][i]==num){
                return false;
            }
        }
        //Checking if Number already exists in the column
        for(int i=0;i<9;i++){
            if(board[i][col]==num){
                return false;
            }
        }
        //Checking if Number already exists in The 3x3 grid
        int startRow = row - row%3;
        int startCol = col - col%3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i+startRow][j+startCol]==num&& (i+startRow!=row && j+startCol!=col)){
                    return false;
                }
            }
        }
        
        //Check if number matches prefilled value
        if(board[row][col]!=0 && board[row][col]!=num){
            return false;
        }

        return true;
    }
    public void printBoard(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]);
                if(j!=8){
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if(i!=8){
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            }
        }
    }
    
    public int[][] getBoard(){
        return board;
    }
}
