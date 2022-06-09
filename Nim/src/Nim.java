import java.util.Random;
import java.util.Scanner;

public class Nim {

    private int stack = 0;
    private int mode = 0;
    private int turn = 0;
    //private String victor;

    Nim(int stack, int mode, int turn) {
        this.stack = stack;
        this.mode = mode;
        this.turn = turn;
    } //assigns stack and mode to this
//==========================================================================================================
    public Nim(int originalStack) {
        Random rand = new Random();
        // creates num 1-100 (the 100 comes from Main's originalStack)
        this.stack =  rand.nextInt(0, originalStack + 1);

        System.out.println("The starting amount of marbles will be: " + this.stack);//prints num 1-100
        //determines if comp is stupid (0) or smart (1)
        this.mode = rand.nextInt(0,2);
        System.out.println("MODE: " + this.mode);
    }//Constructor
    //===========================================================================================
    public void startGame() {
        Random rand = new Random();
        this.turn = rand.nextInt(0, 2);
        if (this.turn == 0)
            System.out.println("Human goes first.");
        else
            System.out.println("Computer goes first.");

        while (0 != this.stack) { //loops between humanTurn and computerTurn
            if (this.turn == 0) {
                this.turn = 1;
                humanTurn();
            }//human

            else if (this.turn == 1) {
                this.turn = 0;
                computerTurn();
            }// robot
        }//while

        if (this.turn == 1)
            System.out.println("Computer wins.");
        else {
            System.out.println("Human wins.");
        }//human wins
    }  //startGame
    //===================================================================================================
    public void computerTurn() {
        Random rand = new Random();
        if (this.mode == 0) {
            int move=1; //decalares 1 as default move

            if(this.stack > 3) { //if the stack is 1,2, or 3, you have to take 1 marble. anything else is random
                move = (rand.nextInt(1, (int) Math.round(this.stack / 2) + 1));
            }
            System.out.println("Computer takes " + move + " marbles.");
            //System.out.println("There are " + this.stack + " marbles in the stack.");
            this.stack = this.stack - move;
        }//dumb play
        //...............................................................................................................
        else { //2^-1   =   3, 7, 15, 31, 63
            int count = 2;
            double goal = 2;
            int move = 1;

            do{
                goal = Math.round(Math.pow(2,count));
                count++;
            }while(goal < this.stack/2);
            goal = goal-1;
            move = this.stack - (int)goal;

            if(this.stack <= 3)
                move = 1;

            System.out.println("Computer takes " + move + " marbles.");
            this.stack = this.stack - move;
            System.out.println("There are " + this.stack + " left.");
        }//smart play
    }//computerTurn Method

    //=============================================================================================
    public void humanTurn() {
        Scanner con = new Scanner(System.in);
        int choice = 0;
        System.out.println("There are " + this.stack + " marbles in the stack.");
        if (3 < this.stack)//3 because if we had 2 marbles we could only take 1
            System.out.println("You can take between 1 - " + Math.round(this.stack / 2) + " marbles.");
        else if ((1 <= this.stack) && (this.stack <= 3)) {
            System.out.println("You can take 1 marble.");
        }
        System.out.println("How many marbles would you like to take?");
        choice = con.nextInt();
        //...............................................................................
        if(this.stack!=1) {
            while ((choice <= 0) || (choice > (int) Math.round(this.stack / 2))) {// keeps user in bounds, re-asks question if its wrong
                System.out.println("OUT OF BOUNDS: try again.");
                choice = con.nextInt();
            }
        }
        else{// if theres only one marble left, it assigns choice to 1
            choice =1;
        }
        this.stack = (this.stack - choice);
        System.out.println("There are " + this.stack + " left.");
    }
}//class Nim