import java.lang.reflect.Array;
import java.util.Scanner;

public class Maze {
    //records the direction the person in the maze is facing
    private String facing;
    private boolean touchingWall=true;

    public void Maze()
    {

    }
    public int[] recursiveMove(String[][] mazeMap, int[] dimensions, int[] loc) {

        //[0] = row
        //[1] = col
        //[2] = handRow
        //[3] = handCol

        //prepares to look forward
        int peakRow = loc[0];
        int peakCol = loc[1];
        boolean touchingWall = false;
        boolean wallAhead = false;
        boolean finish=false;
        //if hand is on wall, make it tru

        switch (facing){
            case "north":
                peakRow-=1;
                break;
            case "south":
                peakRow+=1;
                break;
            case "east":
                peakCol+=1;
                break;
            case "west":
                peakCol-=1;
                break;
            case "finish":
                break;
        }
        if (mazeMap[loc[2]][loc[3]].equals(" #"))
            touchingWall = true;

        //if the spot ahead is a wall, make it true;
        if (mazeMap[peakRow][peakCol].equals(" #"))
            wallAhead = true;
        if (mazeMap[peakRow][peakCol].equals(" F")) {
            facing = "finish";
        }


        switch (facing) {
            case "north":
                if(!touchingWall){
                    mazeMap[loc[0]][loc[1]] = " X";
                    facing="east";
                    loc[1]+=1;
                    loc[2]+=1;

                }//NOT touching wall
                else{
                    if(wallAhead) {
                        facing="west";
                        loc[2]-=1;
                        loc[3]-=1;

                    }
                    else{
                        mazeMap[loc[0]][loc[1]] = " X";
                        loc[0] -= 1;
                        loc[2] -= 1;

                    }//No wall ahead

                }//touching wall
                break;
            case "south":
                if(!touchingWall){
                    mazeMap[loc[0]][loc[1]] = " X";
                    facing="west";
                    loc[1]-=1;
                    loc[2]-=1;
                }
                else{
                    if(wallAhead){
                        facing="east";
                        loc[2]+=1;
                        loc[3]+=1;
                    }
                    else{
                        mazeMap[loc[0]][loc[1]] = " X";
                        loc[0]+=1;
                        loc[2]+=1;
                    }//No wall ahead

                }//NOT touching wall
                break;
            case "east":
                if(!touchingWall){
                    facing="south";
                    mazeMap[loc[0]][loc[1]] = " X";
                    loc[0]+=1;
                    loc[3]-=1;
                }//!touchingWall
                else{
                    if(wallAhead){
                        facing="north";
                        loc[2]-=1;
                        loc[3]+=1;
                    }//wallAhead
                    else{
                        mazeMap[loc[0]][loc[1]] = " X";
                        loc[1]+=1;
                        loc[3]+=1;
                    }//no Wall ahead
                }//touchingWall
                break;

            case "west":
                if (!touchingWall) {
                    mazeMap[loc[0]][loc[1]] = " X";
                    facing = "north";
                    loc[0] -= 1; //moves up
                    loc[3] += 1; //moves hand up
                }
                else{
                    if (wallAhead) {
                        facing = "south";
                        loc[2] += 1;//moves hand down
                        loc[3] -= 1;//moves hand left
                    }//if there's a wall ahead AND you're touching a wall
                    else {
                        mazeMap[loc[0]][loc[1]] = " X";
                        loc[1] -= 1;
                        loc[3] -= 1;
                    }
                }//touchingWall
                break;

            case "finish":
                mazeMap[loc[0]][loc[1]]= " X";
                print(mazeMap);
                finish=true;
        }//switch

        if(!finish)
            recursiveMove(mazeMap, dimensions, loc);
        return loc;
    }//recursiveMove

    //finds dimensions of the text file
    public int[] getDimensions(Scanner file){
        int countRows=0, countCols;
        int[] array= new int[2];

        do{
            countRows++;
            String line = file.nextLine();//casts the line to a string
            line = line.trim();//trims white spaces off ends
            //System.out.println(line);//prints whole maze

            String[] splitLine = line.split("\\s+");//separates by space
            countCols=0;
            for (String i: splitLine)
                countCols++;//counts columns
        }while(file.hasNextLine());
        array[0]=countRows;
        array[1]=countCols;
        return array;
    }//gets dimensions of maze
    //fills 2d array with maze
    public String[][] fillMap(int[] dimensions, Scanner file){
        String mazeMap[][] = new String[dimensions[0]][dimensions[1]];
        for(int i=0;i<dimensions[0];i++) {
            String line = file.nextLine();

            line = line.trim();
            String[] splitLine = line.split("\\s+");

            for(int k=0;k<dimensions[1];k++){
                mazeMap[i][k] = " "+splitLine[k];
                //System.out.println("Splitline k: "+splitLine[k]);
            }
        }//for rows

        return mazeMap;
    }//...DONE

    //returns coords for entrance and hand location
    public int[] entranceLocation(String[][] mazeMap, int[] dimensions){
        int[] coords = new int[4];//[row, col, handRow, handCol]
        boolean found=false;

        for(int i=0;i<dimensions[1];i++) {
            if (mazeMap[0][i].equals(" .")) {
                coords[0] = 0;//row
                coords[1] = i;//col
                coords[2] = 0;//handRow
                coords[3] = coords[1] - 1;//handCol
                found=true;
                facing = "south";
                break;
            }//checks first row
            else if (mazeMap[dimensions[0] - 1][i].equals(" .")) {
                coords[0] = dimensions[0] - 1;//row
                coords[1] = i;//col
                coords[2] = dimensions[0] - 1;//handRow
                coords[3] = coords[1] + 1;//handCol
                found=true;
                facing = "north";
                break;
            }//checks last row
        }
        if(!found) {
            for (int i = 0; i < dimensions[0]; i++) {
                if (mazeMap[i][0].equals(" .")) {
                    coords[0] = i;//row
                    coords[1] = 0;//col
                    coords[2] = coords[0] + 1;//handRow
                    coords[3] = 0;//handCol
                    facing = "east";
                    break;
                }//checks left edge
                else if (mazeMap[i][dimensions[1] - 1].equals(" .")) {
                    coords[0] = i;//row
                    coords[1] = dimensions[1] - 1;//col
                    coords[2] = coords[0] - 1;//handRow
                    coords[3] = dimensions[1] - 1;//handCol
                    facing = "west";
                    break;
                }//checks right edge
            }//for
        }//!found
        return coords;
    }//...DONE
    //printMap
    public static void print(String[][] mazeMap){
        for(int i = 0; i < mazeMap.length; i++) {
            for(int j = 0; j < mazeMap[i].length; j++){
                System.out.print(mazeMap[i][j]);
            }//col for (inside rows)
            System.out.println();
        }//row for
    }
    //prints coordinates
    public static void print(int[] loc){
        System.out.println("current [row,col]: " +"["+ loc[0] + ", "+loc[1]+"]");
        System.out.println("current [handRow,handCol]: "+"[" + loc[2] + ", "+loc[3]+"]");
    }




}
