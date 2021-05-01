import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Sudoku puzzle = new Sudoku();
        if(!puzzle.loadSudoku()){return;}
        puzzle.printSudoku();
    }
}