import java.util.Random;
import java.util.Scanner;

public class MyArray {

    private int arrayOne[];
    private final int SIZE = 10; //caps are final (constants)
    private int arrayTwo[];

    //*************************************************************
    public MyArray(){
        Random rand = new Random();

        arrayOne = new int[SIZE];

        for (int i = 0; i <SIZE; i++){
            arrayOne[i] = rand.nextInt(1,11); //1-10
        }//for
        for(int i : arrayOne){ //the i is only declared in the for loop
            System.out.println(i);
        }
    }
    //*************************************************************
    public void methodTwo(){
        for( int i =9; i>=0; i--){
            System.out.println(arrayOne[i]);
        }
    }
    //*************************************************************
    public void methodThree(){
        int largest = 0;
        int secLargest = 0;
        for(int i = 0; i<=9; i++){
            if(arrayOne[i] >= largest){
                largest = arrayOne[i];
            }
            else if((secLargest <= arrayOne[i]) && (arrayOne[i] <largest)) {
                secLargest = arrayOne[i];
            }
        }
    System.out.println("Method Three: " + largest + " : " + secLargest);
    }//methodThree
    //*************************************************************
    public void methodFour(){
        double temp = 0;
        for(int i = 0; i <=9; i++){
            temp = temp+ arrayOne[i];
        }
        System.out.println("Method Four: " + temp/arrayOne.length);
    }
//*************************************************************
    public void methodFive(){
        Scanner con = new Scanner(System.in);
        int choice = 1;

        System.out.println("Enter a number to search for: ");
        choice = con.nextInt();

        for(int i=0; i <=9; i++){
            if(choice == arrayOne[i]){
                System.out.println("found: " + choice);
            }//if
        }//for
    }//methodFive
    //*************************************************************
    public void methodSix(){
        for(int i =0; i <=9;i++){
            for(int j=0; j != arrayOne[i]; j++){
                System.out.print("*");
            }
            System.out.println ();
        }//for
        }//methodSix
    //*************************************************************
    public void methodSeven(){
        int count = 0;
        arrayTwo = new int[SIZE]; //array of 10 all values are 0
        for(int i = 0; i <SIZE; i++){
            arrayTwo[i] = i+1;
            //System.out.println("scary" + arrayTwo[i]); //
        }//for

        for(int i = 0; i <SIZE; i++) {
            count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (arrayTwo[i] == arrayOne[j]) {
                    count++;
                }//if
            }//for
            if(count == 0){
                continue;
            }//if
            else{
                System.out.println("The number " + arrayTwo[i] + " is in the array " + count + " times.");
            }//else
        }//for
    }//methodSeven
}//class
