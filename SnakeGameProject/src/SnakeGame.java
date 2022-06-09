import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    private int score=0;
    public int isDead=1;

    //function to return the value of isDead
    public int isDead(){
        return isDead;
    }

    private int ogSnakeX, ogSnakeY , snakeY, snakeX;

    //constructor
    public SnakeGame(int SIZE) {
        //positions all values to the center of board
        ogSnakeX= SIZE/2;
        ogSnakeY= SIZE/2;
        snakeY = SIZE/2;
        snakeX = SIZE/2;
   }
    public static String[][] play(int SIZE){
        String[][] board = new String[SIZE][SIZE];//makes array with size
        for(int i = 0; i<SIZE;i++){
            for(int j=0; j<SIZE;j++){
                board[i][j] = ". ";//fills array with ". "
            }//for j
        }//fills board with ". "
        board[SIZE/2][SIZE/2] = "S ";//puts snake head in middle of board
        return board;
    }//returns board w/ snake head

    public static String[][] placeX(String[][] board, int SIZE){
        Random rand = new Random();
        boolean isDot = false;
        int x_ax, y_ax; //x and y coordinates

        //if the spot isnt a dot...
        while(!isDot)   {
            x_ax = rand.nextInt(SIZE);//generate random x
            y_ax = rand.nextInt(SIZE);//generate random y
            if(board[x_ax][y_ax].equals(". ")) {// if the spot is a dot...
                board[x_ax][y_ax] = "X ";
                isDot = true;//breaks loop if its legal position
            }//if

            else
                continue;
        }//while
        return board;
    }//places X on dot...

    public String[][] playMove(String[][] board, int SIZE) {
        Scanner con = new Scanner(System.in);
        String choice = con.nextLine();
        char move = choice.charAt(0);

            //idk how it got switched up, the values are weird but it works
            switch (move) {// chooses move
                case 'w':
                    snakeX -= 1;break;
                case 'a':
                    snakeY -= 1;break;
                case 'd':
                    snakeY += 1;break;
                case 's':
                    snakeX += 1;break;
                default: break;
            }

        //if it goes out of bounds from x
        if (0 > snakeX || snakeX == SIZE) {
            board[ogSnakeX][ogSnakeY] = "O ";//makes death by x
            snakeX = ogSnakeX;//keeps snake head in bound
            snakeY = ogSnakeY;
            isDead = 2;

        }
        //out of bounds detection for Y
        else if (0 > snakeY || snakeY >= SIZE) {
            board[ogSnakeX][ogSnakeY] = "O ";//makes death by Y
            snakeX = ogSnakeX;//keeps snake head in bound
            snakeY = ogSnakeY;
            isDead = 2;

        }
        //if it's the body
        else if (board[snakeX][snakeY].equals("O ")) {
            System.out.println(isDead+"(5");
            board[ogSnakeX][ogSnakeY] = "O ";
            isDead = 3;
        }
        //if it's available
        else if (board[snakeX][snakeY].equals(". ")) {//if the spot is available
            board[snakeX][snakeY] = "S ";//makes move into S
            board[ogSnakeX][ogSnakeY] = "O ";// changes original position to "O "
            board[snakeX][snakeY] = "S ";// the problem "S"
            ogSnakeX = snakeX;
            ogSnakeY = snakeY;
            System.out.println(isDead+"(6");
        }
        //if it's an 'apple'
        else if (board[snakeX][snakeY].equals("X ")) {//when it eats the X
            board[ogSnakeX][ogSnakeY] = "O ";// changes original position to "O "
            board[snakeX][snakeY] = "S ";
            ogSnakeX = snakeX;
            ogSnakeY = snakeY;
            System.out.println("placeX?");
            placeX(board, SIZE);
            score += 1;
        }
        return board;
    }//playMove

    //prints board
    public void printBoard(String[][] board, int SIZE){
        for(int i = 0; i<SIZE;i++){
            for(int j=0; j<SIZE;j++){
                System.out.print(board[i][j]+"");
            }//for j
            System.out.println();
        }//for i
        System.out.println("Score: "+ score + "   Direction: ");
    }//DONE
}//class
