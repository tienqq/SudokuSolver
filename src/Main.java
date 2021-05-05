import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int[][]puzzle = {{0,0,7,0,1,8,0,0,9},
                         {0,0,8,5,0,0,7,0,2},
                         {0,0,6,0,7,0,0,4,0},
                         {0,7,5,0,0,6,0,0,0},
                         {2,8,0,9,0,4,0,3,7},
                         {0,0,0,1,0,0,5,9,0},
                         {0,1,0,0,3,0,4,0,0},
                         {4,0,3,0,0,5,2,0,0},
                         {7,0,0,6,4,0,9,0,0}};
        SudokuSolver solveBacktrack = new SudokuSolver(puzzle);
        System.out.println("Sudoku puzzle that we're gonna solve using backtracking:");
        solveBacktrack.printSolvedPuzzle();
        long start = System.currentTimeMillis();
        if(solveBacktrack.backtrack(solveBacktrack.puzzle)){
            System.out.println("\nSolution: \n");
            solveBacktrack.printSolvedPuzzle();
            System.out.println("\nSolved in "+(System.currentTimeMillis()-start)+"ms");
        }
        else{
            System.out.println("No solution found");
        }
    }
}