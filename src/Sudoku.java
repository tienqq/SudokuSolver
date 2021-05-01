import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Sudoku {
    public int[][] puzzle;
    private int size;

    public Sudoku(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of puzzle: ");
        size = input.nextInt();
        input.close();
        puzzle = new int[size][size];
    }
    public boolean loadSudoku()
    {
        try
        {
            Scanner scan = new Scanner(new File("puzzle.txt"));

            if (!scan.hasNextLine())    {System.out.println("Empty File. Exiting..."); return false;}

            for (int i = 0; i < puzzle.length; i++)
            {
                for (int j = 0; j < puzzle[i].length; j++)
                {
                    puzzle[i][j] = scan.nextInt();
                }
            }
            scan.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found. Please create a puzzle.txt in the same folder this app is in. Exiting...");
        }
        System.out.println("Sudoku is now loaded.");
        return true;
    }

    public void printSudoku()
    {
        int r = 0;
        int c = 0;
        String repeatedStar = new String(new char[4*puzzle.length+4]).replace('\0', '-');
        for (int[] i: puzzle)
        {
            if (r % puzzle.length == 0)
                System.out.print(repeatedStar+'\n');
            for(int j: i)
            {
                if (c % puzzle[0].length == 0)
                    System.out.print('|');
                if (j < 10)
                    System.out.print("  " + j + " ");
                else
                    System.out.print(" " + j + " ");
                c++;
            }
            r++;
            System.out.print("|");
            System.out.println();
        }
        System.out.print(repeatedStar+'\n');
    }
}
