package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;


public class Main {
    public static int[] createIntArray(String line){
        int[] intLine = new int[3];     //array of 3
        String[] strLine = line.split(" ");     //makes String array with the numbers
        for(int i =0; i<3;i++){     //loops through the 3 numbers
            intLine[i]=Integer.parseInt(strLine[i]);    //fills int array with a converted string input from strArray
            //System.out.println(intLine[i]);//prints int array value
        }//for
        return intLine;
    }//createArray

    public static void main(String[] args) throws IOException {
        //=========READ FILE=========================================
        System.out.print("File name: ");
        Scanner input = new Scanner(System.in);//user's input
        File txt =new File(input.nextLine());//creates file with "inputFile.txt"
        if(!txt.exists()) {
            System.out.println("Sorry, doesn't exist.");
            System.exit(0);//terminates program
        }// if the file doesn't exist, tell the user.
        Scanner file = new Scanner(txt);

        int fileCount=1;//counts file for naming purposes
        while(file.hasNextLine()) {    //loops as long as there are lines
            String line = file.nextLine();    //converts line into string
            int[] numSet = createIntArray(line); //separates str array into ints and casts them to an array

            if (numSet[0] == 0 && numSet[1] == 0 && numSet[2] == 0)
                System.exit(0);

            int personNum = 1;//assigns order numbers to Nodes

            LinkedList candidates = new LinkedList();//creates Linked List
            for (int i = 0; i < numSet[0]; i++) {
                Node person = new Node(personNum); //makes node with int of their order
                personNum++;    //increments people's numbers
                candidates.addToBack(person);// add candidates behind first
            }//adds 'n' amount of Nodes to circular doubly ll

            //creates iterator
            Node k = candidates.getFirst(); //Returns Nodes of first
            Node m = candidates.getLast();  //and last

            //Write to file
            FileWriter fWriter = new FileWriter("LinkedListProgram"+fileCount+".txt");
            fileCount++;
            fWriter.write("Program 4"+"\n"+"---------"+"\n"+"\n");
            fWriter.write("N = "+numSet[0] + ", k = "+ numSet[1] + ", m = "+ numSet[2]+"\n"+"\n");
            fWriter.write("Output"+ "\n"+ "------");

            int listSize = candidates.getLength();//gets length of linked list
            boolean isK = true; //checks what N

            boolean hasWinner = false;//checks if we have a winner yet
            int winner=0;//stores winner

            while (listSize != 0) {
                k = candidates.move(k, numSet, listSize, isK);
                isK = false;
                m = candidates.move(m, numSet, listSize, isK);
                isK = true;
                String people;

                if (k == m && hasWinner==false) {
                        winner = m.getData();
                        hasWinner=true;

                }//if k and m are on the same node, assign winner
                if(m!=k)
                    people ="\n"+ k.getData() + " " + m.getData();
                else
                    people="\n"+k.getData();

                try {
                    fWriter.write(people);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                //System.out.println(people);

                k = candidates.remove(k, true, listSize);
                listSize--;
                if (listSize > 0) {
                    if (k == m) {
                        k = k.getPrev();
                    }
                    m = candidates.remove(m, false, listSize);
                    listSize--;
                }
                if (listSize <= 0) {
                    break;
                }
            }//while

            fWriter.write("\n"+"\nEnd of Project");
            fWriter.close();
        }
    }//main
}//class