import java.util.Arrays;

public class Backtracking {
    public int[][]puzzle;
    private final int size = 9;

    public Backtracking(int[][]puzzle){
        this.puzzle = puzzle;
    }

    public boolean backtrack(int[][] puzzle){
        return solveBacktrack(puzzle, 0 , 0);
    }
    private boolean solveBacktrack(int[][] puzzle, int row, int col){
        //if we reached the 8th row and 9th column, we are done
        if(row == size-1 && col==size){
            return true;
        }
        //if col = 9 then move onto next row and reset col back to 0
        if(col == size){
            row++;
            col=0;
        }
        //check to see if there isn't already a value in the current position
        if(puzzle[row][col] != 0){
            return solveBacktrack(puzzle, row, col+1);
        }

        //iterate through possible values
        for(int i=1; i<10; i++){
            //check to see if it's safe to place value at the position
            if(isSafe(puzzle,row,col,i)){
                puzzle[row][col]=i;

                //check for next column possibility
                if(solveBacktrack(puzzle,row,col+1)) return true;
            }
            //reset and move onto next value
            puzzle[row][col]=0;
        }
        return false;
    }
    private boolean isSafe(int[][]puzzle, int row, int col, int num){
        //check to see if the num is already in the row
        for(int i=0;i<size;i++){
            if(puzzle[row][i]==num) return false;
        }
        //check to see if num is already in the column
        for(int i=0;i<size;i++){
            if(puzzle[i][col]==num) return false;
        }
        //check to see if num is in the 3x3 grid
        int rowIndex = row - row % 3;
        int colIndex = col - col % 3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(puzzle[i+rowIndex][j+colIndex]==num) return false;
            }
        }
        return true;
    }

    public void printPuzzle(){
        for(int[] x: puzzle)
            System.out.println(Arrays.toString(x));
    }
}
