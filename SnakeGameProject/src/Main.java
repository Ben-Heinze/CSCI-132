public class Main {

    public static void main(String args[]){

        final int SIZE = 20;//size of board
        SnakeGame game =new SnakeGame(SIZE);
        int isDead;
        //makes board, generates x,then prints it
        String[][] board = game.play(SIZE);
        game.placeX(board, SIZE);
        game.printBoard(board, SIZE);
        do{//while not dead
            board = game.playMove(board, SIZE);
            isDead = game.isDead();

            System.out.println("isDead?: "+isDead);
            game.printBoard(board, SIZE);
        }while(isDead==1);

        switch(isDead){
            case 2://if you hit a wall, isDead = 2
                System.out.println("YOU HIT WALL, YOU LOSE"); break;
            case 3:
                System.out.println("HIT YOURSELF, YOU LOSE");break;

        }//SWITCH

    }//main
}//class
