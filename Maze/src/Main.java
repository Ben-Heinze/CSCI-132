import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws FileNotFoundException {
        Scanner input = new Scanner(args[2]);
        File txt = new File(input.nextLine());

        Scanner file = new Scanner(txt);
        Scanner file2 = new Scanner(txt);//cursor doesnt reset so i have 2

        Maze maze = new Maze();

        int[] dimensions= maze.getDimensions(file);//[rows,cols]

        String[][] mazeMap = maze.fillMap(dimensions,file2);
        maze.print(mazeMap);
        //make this work later,maybe have it choose hand location too
        int[] loc = maze.entranceLocation(mazeMap, dimensions);//stores moving coordinates
        //maze.print(loc);
        //System.out.println("facing "+maze.getFacing());
        System.out.println();
        System.out.println("=== === === === === === === === === === === === === ===");
        System.out.println();
        loc = maze.recursiveMove(mazeMap,dimensions,loc);
        System.out.println("You are a winner!");
    }//main
}
